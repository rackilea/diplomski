case 2:
                        System.out.println("Add");
                        Student student = MenuMethods.userInput();
                        details.add(student);
file.write(student.toString().getBytes());
                    break;