String new1 = "Some text";
PrintWriter outs;
try {
    outs = new PrintWriter("D:/text123.txt");
    outs.write(new1 + System.getProperty("line.separator"));
    outs.write(new1 + System.getProperty("line.separator"));
    outs.write(new1 + System.getProperty("line.separator"));
    outs.close();
} catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
}