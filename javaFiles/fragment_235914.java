public static void main(String[] args) throws IOException {

String[] myArray;
double[] doubleArray = new double[5];
String[] strArray= new String[5];

     int inc1=0;
     int inc2=0;
     FileReader fileReader = new FileReader("test.txt");
     Scanner s= new Scanner(fileReader);

     while(s.hasNext()){
           myArray= s.next().split(",");
       // to store double values
    for (String getStr: myArray) {
        if(isDouble(getStr)==true){
            doubleArray[inc1]= Double.parseDouble(getStr);
            inc1++;
        }
       // to store string values
        else {
            strArray[inc2]=getStr;
            inc2++;
        }
  }
  }

      for(String ss : strArray){
             System.out.println("str value-> : "+ ss);
         }
         for(Double nnn : doubleArray){
             System.out.println("double value-> : " + nnn);
         }

      fileReader.close();

}