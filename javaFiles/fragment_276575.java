//try to find the word
BufferedReader in = new BufferedReader(new FileReader("D:/File.txt"));
boolean found = false;
while (( line = in.readLine()) != null)
{
    if (line.contains(str))
    {
        found = true;
        break; //break out of loop now
    }
}
in.close();

//if word was found:
if (found)
{
    System.out.println("Yes");
}
//otherwise:
else
{
    System.out.println("No");

    //wait until it's necessary to use an output stream
    BufferedWriter out = new BufferedWriter(new FileWriter("D:/File.txt",true));
    out.newLine();
    out.write(str);
    out.close();
}