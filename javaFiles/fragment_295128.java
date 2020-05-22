BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"));
try
{
    for(int i=0;i<n;i++)
    {
        s[i]=new StudentInfo();
        System.out.println("Student "+(i+1));
        s[i].getDetails();
        writer.write(s[i].rno + ": " + s[i].name);
        writer.newline();
    }
}
finally
{
    writer.close(); // Close output even if there's an error
}