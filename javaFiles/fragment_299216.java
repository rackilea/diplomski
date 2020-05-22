while(reader.hasNextLine()){
    String[] values = reader.nextLine().split("\\s+");
    name= values[0];
    salary = Double.valueOf(values[1]);
    System.out.println(name + " " + salary + "\r\n");
}