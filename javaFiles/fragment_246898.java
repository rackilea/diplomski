Scanner scan=new Scanner(System.in));
fileName="";
System.out.print("Please choose a dataset (1) dataset.txt , (2)data.txt : ");
int input = scan.nextInt();
if(input==1){
   fileName="dataset.txt";
}
if(input==2){
   fileName="data.txt";
}
File inputFile=new File(fileName));
... .