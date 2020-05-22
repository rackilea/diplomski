where    
   IF_KEYWORD                    = { if }   
   LEFT_FUNCTION_BRACKET         = { ( }    
   EXPRESSION                    = { WITHOUT_OPERATOR, WITH_OPERATOR }       
   WITHOUT_OPERATOR              = { SIMPLE_OPERAND, OPERAND_WITH_FUNC }      
   SIMPLE_OPERAND                = { OPERAND }    
   OPERAND_WITH_FUNC             = { OPERAND.FUNC(), !OPERAND.FUNC() }     
   WITH_OPERATOR                 = { SIMPLE_OPERAND_WITH_OPERATOR,  OPERAND_WITH_FUNC_OPERATOR }   
   SIMPLE_OPERAND_WITH_OPERATOR  = { LEFT_OPERAND OPERATOR RIGHT_OPERAND }
   OPERAND_WITH_FUNC_OPERATOR    = { OPERAND_WITH_FUNC OPERATOR OPERAND_WITH_FUNC  }    
   LEFT_OPERAND                  = { OPERAND }   
   RIGHT_OPERAND                 = { OPERAND }    
   OPERATOR                      = { !=, ==, >, <, >=, <= }    
   OTHER                         = { RIGHT_CURLY_BRACES, NEW_LINE} 
   RIGHT_CURLY_BRACES            = { { } 
   NEW_LINE                      = { \n } 
so on and so forth..