where_clause
    :   condition_or
    ;

condition_or
    :   ^('or' condition_and condition_and)
    ;

condition_and
    :   ^('and' condition_expr condition_expr)
    ;

condition_expr
    :   condition_comparision
    ;

condition_comparision
    :   ^('=' column_identifier sql_element)
    |   ^('!=' column_identifier sql_element)
    |   ^('>' column_identifier sql_element)
    |   ^('<' column_identifier sql_element)
    ;