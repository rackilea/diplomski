public static void main(String[]args){
 int total = 0;
 int counter = 0;
 Scanner inFile = null;

 try{
 inFile = new Scanner(new File("fileName.txt"));

 while(inFile.hasNext()){
  total += inFile.nextInt();
  counter++;
 }

}catch(FileNotFoundException e){
 e.printStackTrace();
 }


System.out.println("Average: "+total/counter);
}