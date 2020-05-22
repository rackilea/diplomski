try
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
str=br.readLine();
i=Integer.parseInt(str);
}catch(IOException e)
{System.out.println("IOException occured... " + e.printStacktrace());
catch(NumberFormatException e)
{System.out.println("enter a valid input");
}