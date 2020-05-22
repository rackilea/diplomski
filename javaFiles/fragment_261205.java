class Primary implements Pdfeable {
   String name; String age;
   public String writeToPDF(){
      return getName() +  "" + getAge();
   }
}