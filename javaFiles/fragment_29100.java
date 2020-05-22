'From VisualWorks, 7.8 of March 30, 2011 on May 1, 2012 at 9:47:31 PM'!


CodeComponent create: #package named: 'IntermediateInterpreter'!"Package IntermediateInterpreter*"!


CodeComponent create: #package named: 'IntermediateInterpreter'!

Smalltalk defineClass: #IntermediateInterpreter
    superclass: #{Core.Object}
    indexedType: #none
    private: false
    instanceVariableNames: 'lines currentLineNumber variables stack commands '
    classInstanceVariableNames: ''
    imports: ''
    category: ''!

!IntermediateInterpreter class methodsFor: 'instance creation'!

new
    ^super new initialize
! !


!IntermediateInterpreter methodsFor: 'initialize-release'!

initialize

    stack := OrderedCollection new.
    variables := Dictionary new.
    lines := OrderedCollection new.
    self initializeCommands
!

initializeCommands

    commands := Dictionary new.
    commands
        at: 'READ' put: [:values | stack add: (self tokenize: (Dialog request: 'value?' initialAnswer: ''))];
        at: 'STORE' put: [:values | variables at: values second put: stack removeLast];
        at: 'PUSH' put: [:values | stack add: ((self isVariableName: values second) ifTrue: [variables at: values second] ifFalse: [values second])];
        at: 'GREATER' put: [:values | | a b | b := stack removeLast. a := stack removeLast. stack add: (a > b ifTrue: [1.0] ifFalse: [0.0])];
        at: 'MULTIPLY' put: [:values | | a b | b := stack removeLast. a := stack removeLast. stack add: a * b ];
        at: 'MINUS' put: [:values | | a b | b := stack removeLast. a := stack removeLast. stack add: a - b ];
        at: 'TESTFGOTO' put: [:values | (stack removeLast - 0.0) abs < 0.01 ifTrue: [currentLineNumber := values second]];
        at: 'TESTTGOTO' put: [:values | (stack removeLast - 1.0) abs < 0.01 ifTrue: [currentLineNumber := values second]];
        at: 'PRINT' put: [:values | Transcript show: stack removeLast printString; cr];
        at: 'END' put: [:values | currentLineNumber := 0]! !

!IntermediateInterpreter methodsFor: 'testing'!

isVariableName: aString

    (aString isKindOf: String) ifFalse: [^false].
    ^aString first isAlphabetic! !

!IntermediateInterpreter methodsFor: 'interpreting'!

interpret: aString

    self createLinesFrom: aString.
    currentLineNumber := 1.
    self interpret!

interpret

    | tokens |
    [currentLineNumber = 0] whileFalse: 
            [tokens := lines at: currentLineNumber.
            Transcript show: tokens printString; cr.
            currentLineNumber := currentLineNumber + 1.
            (commands at: tokens first asUppercase
                ifAbsent: [self error: 'Unknown command']) value: tokens]!

tokenizeLine: aString

    ^(((aString tokensBasedOn: Character space)
        reject: [:each | each isEmpty]) collect: [:each | self tokenize: each]) asArray!

tokenizeCurrentLine

    ^(((lines at: currentLineNumber) tokensBasedOn: Character space)
        reject: [:each | each isEmpty]) collect: [:each | self tokenize: each]!

createLinesFrom: aString

    | stream |
    stream := aString readStream.
    [stream atEnd] whileFalse: [lines add: (self tokenizeLine: (stream upTo: Character cr))]!

tokenize: each

    ^(self isVariableName: each)
        ifTrue: [each]
        ifFalse: [Number readFrom: each readStream]! !