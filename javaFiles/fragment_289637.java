Scanner file = new Scanner(new FileInputStream("/.../file.txt"));
PrintWriter p = new PrintWriter(new FileWriter("/.../output.txt"));

int count = 0;

while (file.hasNextLine()) 
{
    String s = file.nextLine();
    count++; 
    try
    {
        if(s.contains("#AVFC")){
            p.printf("There are %d words on this line ", s.split("\\s").length-1);
            p.println(count);

        }
    }
    catch(Exception ex){ 
        ex.printStackTrace(); 
    } 



}

p.close();
file.close();