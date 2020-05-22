public Boolean isAntique(){
   int year = Calendar.getInstance().get(Calendar.YEAR);

   if(year - this.year >= 45) {
       return true;
   } else {
       return false;
   }
}