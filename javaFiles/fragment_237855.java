case 3: 
    if(PatientList.isEmpty()) 
    {
        try 
        {
            //load data from the hard drive
        } catch (FileNotFoundException e) {
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }

        //populate PatientList if data was loaded from disk here

        //if PatientList is still empty then print out no patients found
        if(PatientList.isEmpty())
        {
            System.out.println("\nNo patients were found...\nReturning to main menu...\n");
        }           
    }

break;