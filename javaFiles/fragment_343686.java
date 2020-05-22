boolean exit = false;
         while(!exit) {

            int option = JOptionPane.showConfirmDialog(null, message, "SimpleCalculator", JOptionPane.OK_CANCEL_OPTION);

            if(option == JOptionPane.OK_OPTION)
            {
                String value1 = field1.getText();
                String value2 = field2.getText();         
                String operation = field3.getText();

                try{
                         int num1 = Integer.parseInt(value1);
                         int num2 = Integer.parseInt(value2);

                        operation = field3.getText();
                        if(operation != null){
                            operation = operation.toLowerCase();
                        }

                        switch(operation)  {
                               case "+":
                               case "addition":

                                          num1 = Integer.parseInt(value1);
                                          num2 = Integer.parseInt(value2);
                                          int result = num1+num2;
                                          JOptionPane.showMessageDialog(null,"The sum is: "+result); 
                                          break;

                               case "-":
                               case "subtraction":

                                          num1 = Integer.parseInt(value1);
                                          num2 = Integer.parseInt(value2);
                                          int result = num1-num2;
                                          JOptionPane.showMessageDialog(null,"The difference is: "+result); 
                                          break;

                                case "*":
                                case "multiplication":

                                          num1 = Integer.parseInt(value1);
                                          num2 = Integer.parseInt(value2);
                                          int result = num1*num2;
                                          JOptionPane.showMessageDialog(null,"The product is: "+result); 
                                          break;

                                case "/":
                                case "division":

                                          num1 = Integer.parseInt(value1);
                                          num2 = Integer.parseInt(value2);
                                          double result = (double)num1/num2;
                                          JOptionPane.showMessageDialog(null,"The quotient is: "+result); 
                                          break;

                               default: 
                                          error1 = JOptionPane.showConfirmDialog(null,"Invalid operation, please try again","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE); //I need help here for creating a loop that will take me back to the beginning.
                        }
                        //option = JOptionPane.showConfirmDialog(null, message, "SimpleCalculator", JOptionPane.OK_CANCEL_OPTION);
                }
                catch(NumberFormatException ne)
                {
                         JOptionPane.showConfirmDialog(null,"Invalid! Please input an integer","Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE); //When I press ok, I need help to bring me back to input entries
                }

            }
            else if (option == JOptionPane.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Thank you for using our program!");
                exit = true;
            }

        }