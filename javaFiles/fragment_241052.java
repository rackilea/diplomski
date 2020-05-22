ResultSet zoeken = stat.executeQuery("SELECT * FROM leden WHERE naam = '" + text + "'");
       boolean val = zoeken.next(); //next() returns false if there are no-rows retrieved 
        if(val==false){
            System.out.println("zoken is empty"); //prints this message if your resultset is empty
         }
        while(val){// only runs when there are rows in the resultset
           System.out.println(zoeken.getString(1) + zoeken.getString(2) + zoeken.getString(3));
          val=zoeken.next(); //updating val again to check if there are rows in result set
        }