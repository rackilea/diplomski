try {
    PrintWriter writer = new PrintWriter("mydata.ser");

    writer.println(getUserName());
    writer.println(getPassword());

    writer.close();
}
catch(Exception ex) {
    ex.printStackTrace();
}

...

try {
    BufferedReader reader = new BufferedReader(new FileReader("mydata.ser"));

    System.out.println(reader.readLine());
    System.out.println(reader.readLine());

    reader.close();
}
catch(Exception ex) {
    ex.printStackTrace();
}