while(scanner1.hasNextLine())
{
    String line = scanner1.nextLine();
    fos1.append(line);
    fos1.newLine();
    if(line.equals("###"))
    {
         scanner1.nextLine();
    }
}