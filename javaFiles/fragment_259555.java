public static void main(String[] args) throws FileNotFoundException  {
    int n = Integer.parseInt(args[0]);
    String filePath = args[1];
    YourClass c = new YourClass();
    c.generate(n, filePath);

}