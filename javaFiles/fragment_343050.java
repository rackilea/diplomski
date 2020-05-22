if (choice.equals("R")){
                System.out.println("Please enter ID of part you would like "
                        + "to replenish");
                String input = sc.nextLine();
                for (Part part: parts) 
                    {
                     if(part!=null && input.equals(part.getID())){
                        System.out.println("Please enter replenish quantity");
                        part.replenish(sc.nextInt());
                     }
                }
             }