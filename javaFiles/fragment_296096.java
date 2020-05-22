case 5:
                System.out.print("Enter The co-ordinates you want to put: ");
                //This scans the next line to get the response from the user.
                userInput = scan.next();
                System.out.print("Enter the code value ");
                String codeValue = scan.next();
                authProvider.addAuthentication(userInput, codeValue);
                break;