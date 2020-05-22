select_clause ::= SELECT [DISTINCT] select_item {, select_item}*
select_item ::= select_expression [[AS] result_variable]
select_expression ::= single_valued_path_expression | scalar_expression | aggregate_expression | 
    identification_variable | OBJECT(identification_variable) | constructor_expression
constructor_expression ::= NEW constructor_name ( constructor_item {, constructor_item}* )
constructor_item ::= single_valued_path_expression | scalar_expression | aggregate_expression |
    identification_variable