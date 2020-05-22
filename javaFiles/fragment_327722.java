...
try {
    File file2 = new File(name+".txt");
    FileWriter fw = new FileWriter(file2,true);
    String s = Integer.toString(points);
    fw.write(s);  
    // a line feed would make the file more readable
    fw.close();
} catch (...