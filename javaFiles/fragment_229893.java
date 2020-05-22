for(int x=0; x < 121; x++){

        String[] bdaynames = {database.readWord(),database.readWord(),database.readWord(),database.readWord(),database.readWord()};
        //System.out.println(Arrays.toString(bdaynames));

        //we get a arraylist
            bmonth = Integer.parseInt(bdaynames[2]);
            bday = Integer.parseInt(bdaynames[3]);
            byear = Integer.parseInt(bdaynames[4]);
            LocalDate start = new LocalDate(year,month,day);
            LocalDate end = new LocalDate(year,bmonth,bday);
            int dayCount = Days.daysBetween(start, end).getDays();
                //System.out.print(dayCount+" ");
            myArray[x] = dayCount;
            if(x == 120){
                    System.out.print("THIS IS THE ONE!): "+Arrays.toString(myArray));
                }
        }