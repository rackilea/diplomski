SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

boolean isValidDate(String input) {
     try {
          format.parse(input);
          return true;
     }
     catch(ParseException e){
          return false;
     }
}