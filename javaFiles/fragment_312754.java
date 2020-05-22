BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

try{
    String filename = br.readLine();
} catch (IOException ioe) {
    System.out.println("IO error");
    System.exit(1);
}