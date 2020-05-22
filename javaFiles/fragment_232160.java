int counter=0;
 while ((sNextLine2 = reader2.readNext()) != null) { 
    counter++;
    switch(sNextLine2[0]) {
        case "ADD":         
            if(sNextLine2[1].isEmpty()) {
                System.out.println("The code number is empty in line" + counter); //how to get that line number

            } else if (mEmployeeList.containsKey(sNextLine2[1]))
            {
                System.out.println("Data already exist");
            }
            else
            {
                mEmployeeList.put(sNextLine2[1],new Employee(sNextLine2[1],
                        sNextLine2[2], sNextLine2[3], sNextLine2[4], sNextLine2[5],
                        sNextLine2[6], sNextLine2[7], sNextLine2[8]));
            }

            break;
    }