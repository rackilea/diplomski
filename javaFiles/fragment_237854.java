case 3: 
    //this if statment is checking if PatientList.size() is 0 or in other words check if it is empty
    if(PatientList.size() == 0) 
    {
        System.out.println("\nNo patients were found...\nReturning to main menu...\n");     
    }
    //this else code block will only run if the above if statment is false
    else 
    {  
        try 
        {
            //load data from the hard drive
        } catch (FileNotFoundException e) {
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }                       
break;