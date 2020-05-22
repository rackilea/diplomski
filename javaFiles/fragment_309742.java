System.out.println("Searching the Binary Search Tree");
                    System.out.println("Enter surname to search for:");
                    String choice2 = sc.nextLine(); 
                    BinaryNode a = temp.search(choice2);
                    if (a == null)
                        {
                            System.out.println("Not Found");
                        }
                    else
                        {
                            Employee newEmp = (Employee) a.obj;
                            System.out.println(newEmp.getData());
                        }
                   break;
                }