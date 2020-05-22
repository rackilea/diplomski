Scanner input = new Scanner(System.in);
            String expression = "";

            System.out.println("Type an expression written in Infix notation: ");
            expression = input.next();

            if(!expression.equalsIgnoreCase("q"))
            {
                do{
                    PostFixConverter convert = new PostFixConverter(expression);
                    System.out.println("This expression writtien in Postfix notation is: \n" + convert.infixToPostfix());

                    System.out.println("Type an expression written in Infix notation: ");
                    expression = input.next();
                }while (!expression.equalsIgnoreCase("q"));
            }   
            }
        }