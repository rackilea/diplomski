normalClassDeclaration
:   classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
    {
    ((CommonToken)$Identifier).setText("TEST");
    }
;