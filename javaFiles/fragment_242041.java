Scanner s=new Scanner(new File("file location"));

while(s.hasNextLine()){
    String line = s.nextLine();
    String[] cols = line.split(",");

    // if every col is empty, the line will equal col-1 delimiters.
    if(line.length() > cols.length - 1){ 
        for(String str : cols){
            System.out.print(str);    
            System.out.print("|");
            System.out.print("\t");
        }
    }
}
s.close();