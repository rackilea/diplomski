expression returns [String value] // A
    ...

    |  '!' expression
    { $value = " ! " + $expression.value; }
;