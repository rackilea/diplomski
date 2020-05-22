Salesperson[] staffList;
        staffList = new Salesperson[20];

        for(int i = 0; i < staffList.length; i++)
        {
            Salesperson salesPerson = staffList[i]; // staffList[i] i.e salesPerson = null.... null.getId throws NPE.

System.out.println("sales =" + sales); // sales = null
            if(sales != null) {
                if (sales.getId().equals(idNum)) {
                      //Do something..
                }
            }

        }