inputStream.nextLine();
while(inputStream.hasNextLine())
{
   String movieArgs = inputStream.nextLine(); 
   String[] splitData = movieArgs.split(",");
   System.out.println(movieArgs);
}