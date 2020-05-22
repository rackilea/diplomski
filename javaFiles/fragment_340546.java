else if(inc_dec.equals("++") && conditionalOperator.equals("!="))
                    {
                     for(float c=initialValue;c!=conditionalValue;c+=interval)
                     {
                      if(conditionalValue%interval == 0)
                         System.out.print("for("+dataType+" "+varName+"="+c+";"+varName+conditionalOperator+conditionalValue+";"+varName+"+="+interval+"){\n}\n");
                      else break;
                     }
                    }