String ex1_query = "insert into parts values ('S5', 'P6', 'J7', 50);";

    String lastValue = ex1_query.substring( ex1_query.lastIndexOf(",")+1, ex1_query.lastIndexOf(")")).trim();

 Integer lastNumber = null;
        try {
            lastNumber = Integer.parseInt(lastValue);
        } catch (NumberFormatException e) {
            // if last value is not int then handle here 
            e.printStackTrace();
        } 
        if(lastNumber >=100){

        }