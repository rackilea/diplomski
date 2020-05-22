private boolean CheckDate(String fromDate, String toDate)
   { 
   boolean result=false;
   try{

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //edit here
            Date dateStart = sdf.parse(fromDate);
            Date dateEnd = sdf.parse(toDate);

            if(dateStart .compareTo(dateEnd)>0){
                System.out.println("dateStart is after dateEnd ");
                 result=false;
            }else if(dateStart .compareTo(dateEnd)<0){
                 System.out.println("dateStart is before dateEnd ");
                 result=true;
            }else if(dateStart .compareTo(dateEnd)==0){
                System.out.println("dateStart is equal to dateEnd ");
                result=true;
            }else{
                System.out.println("How to get here?");
            }

        }catch(ParseException ex){
            ex.printStackTrace();
        }
  return result;

  }