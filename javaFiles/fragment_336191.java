update_statement ::= update_clause [where_clause]

update_clause ::= UPDATE abstract_schema_name [[AS] identification_variable] SET update_item {, update_item}*

update_item ::= [identification_variable.]{state_field | single_valued_association_field}= new_value

new_value ::= simple_arithmetic_expression | string_primary | datetime_primary | boolean_primary | enum_primary simple_entity_expression | NULL

simple_arithmetic_expression ::= arithmetic_term | simple_arithmetic_expression {+ |- } arithmetic_term

simple_entity_expression ::= identification_variable | input_parameter

arithmetic_term ::= arithmetic_factor | arithmetic_term {* |/ } arithmetic_factor

arithmetic_factor ::= [{+ |-}] arithmetic_primary

arithmetic_primary ::= state_field_path_expression | numeric_literal | (simple_arithmetic_expression) | input_parameter | functions_returning_numerics | aggregate_expression

functions_returning_numerics ::= LENGTH(string_primary)| LOCATE(string_primary,string_primary [, simple_arithmetic_expression]) | ABS(simple_arithmetic_expression) | SQRT(simple_arithmetic_expression) | MOD(simple_arithmetic_expression, simple_arithmetic_expression) | SIZE(collection_valued_path_expression)

aggregate_expression ::= {AVG |MAX |MIN |SUM}([DISTINCT] state_field_path_expression) | COUNT ([DISTINCT] identification_variable | state_field_path_expression | single_valued_association_path_expression)

single_valued_association_path_expression ::= identification_variable.{single_valued_association_field.}* single_valued_association_field

string_primary ::= state_field_path_expression | string_literal | input_parameter | functions_returning_strings | aggregate_expression

datetime_primary ::= state_field_path_expression | input_parameter | functions_returning_datetime | aggregate_expression

boolean_primary ::= state_field_path_expression | boolean_literal | input_parameter |

enum_primary ::= state_field_path_expression | enum_literal | input_parameter |

where_clause ::= WHERE conditional_expression
...