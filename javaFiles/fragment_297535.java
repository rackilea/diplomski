public static void main(String[] args){
   Tests tests= new Tests();
   String inputString =tests.takeInput();
   tests.setName(inputString);
   tests.displayInfo();
}