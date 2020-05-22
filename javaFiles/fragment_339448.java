if(args[0]!=null&&!args[0].isEmpty()){
      inputFile=new File(args[0]);
}

if(inputFile==null){
   do{
       Scanner console=new Scanner(System.in);
       System.out.print("enter file:");
       String fileName=console.next();
       inputFile=new File(fileName);
       Scanner in=new Scanner(new File(fileName));
       countBrackets(in);
    }while(!inputFile.exists());
}