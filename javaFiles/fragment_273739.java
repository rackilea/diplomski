String produceIdMethod(String input){

       String sub = input.substring(0, 7);//sub has 1st 7 characters

      //now fire a db query as select columnnameforid from table where columnnameforid like ':sub%' order by columnnameforid asc; 
      //and set sub dynamically using setparameter. it should give list of ids in ascending order
      //get last value of the list and lets say it as strDB
      if(retrived list is null or empty)
          return sub+"001";

      String temp = strDB.substring(7, strDB.length);//get only digits in id
      Integer i = Integer.parseInt(temp);//convert it to list
      i=i+1;//increment it
      if( i < 10 ) {
            return sub+ "00" + i;//prefix 00 if its single digit value
        }
        if( i < 100) {
            return sub+ "0" + i;prefix 0 if its double digit value
        }
        return sub+ index;//otherwise return as it is  }