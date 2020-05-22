do {
 if (lineTwo.toLowerCase().contains(keyterm.toLowerCase())) {
    found = true;
    System.out.println("Found "+keyterm);          
    System.out.println(line);
    System.out.println(lineTwo);

 }
} while (((lineTwo = br.readLine())!=null)&(!found));