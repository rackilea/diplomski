FileReader file = new FileReader(new File("File.dat"));
BufferedReader br = new BufferedReader(file);
String temp = br.readLine(); 
while (temp != null) {

    String[] tabSeparatedArray = temp.split("\t")
    foreach(String tabElement : tabSeparatedArray){
        if (tabElement.trim().length <= 0){
            //here the element is blank... do whatever you want!!!!
        }
    }
    System.out.println(temp);
    temp = br.readLine();
}