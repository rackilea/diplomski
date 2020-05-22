boolean found = false;
while (( line = bf.readLine()) != null) {

    linecount++;
    int indexfound = line.indexOf(args[0]);
    if (indexfound > -1) {
        System.out.println("fruit exist on line " + linecount);
        System.out.println("add another fruit");   
        found = true;
        break;
    }
}

if (!found) {

    BufferedWriter bw = new BufferedWriter(new FileWriter("fruit.txt", true));
    String fruit = "";
    fruit = args[0];

    bw.write("\r\n" + fruit);
    System.out.println(fruit+ "added"); 

    bw.close();  // You need to close it here only. 
}

bf.close();