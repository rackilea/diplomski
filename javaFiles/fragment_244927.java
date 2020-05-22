String line;
int init=0;
while((line= Fileread.readLine())!=null)
    {
System.out.println(line.length());
    if(line.length()==0)
        break;
    try
    {
        memory[init]=Integer.parseInt(line.trim().split(" ")[0]);
        System.out.println(memory[init]);
        init++;
    }
    catch(NumberFormatException e)
    {
        init=Integer.parseInt(line.substring(1));
    }
}