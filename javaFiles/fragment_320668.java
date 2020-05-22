expression returns [String value] // A
    ...

    |  '!' e = expression
    { $value = " ! " + $e.value; }
;