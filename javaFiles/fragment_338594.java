else if ( option == 3)
            {
                System.out.print("Enter the first name of student will be deleted: ");
                String removeName = scan.next();
                System.out.print("Enter the last name of student will be deleted: ");
                String removeLastName = scan.next();

                for ( int i = 0; i < studentList.size(); i++)
                {
                    Student deleted = studentList.get(i);

                    if ( deleted.getFirstName().toLowerCase().equals(removeName.toLowerCase()) && deleted.getLastName().toLowerCase().equals(removeLastName.toLowerCase()))
                    {
                        studentList.remove(i);
                        System.out.println("The student has been deleted.");
                        break;
                    }
                    else
                    {
                        System.out.println("This student is not found");
                        break;
                    }

                }

            }