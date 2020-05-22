Scanner scan = new Scanner( ret.getData() );
scan.nextLine(); //skip the first line

While (scan.hasNextLine()){
     String s = scan.nextLine();
     int index = s.lastIndexOf("=");
     System.out.println(s.substring(index+1));
}