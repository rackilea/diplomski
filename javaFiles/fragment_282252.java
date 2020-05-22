try
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str=br.readLine();
    i=Integer.parseInt(str);
    }
catch(IOException | NumberFormatException ex) {
System.out.println(ex.printStackTrace())
}