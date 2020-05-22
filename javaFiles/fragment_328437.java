FileReader fr = new FileReader("infile.txt"); 
BufferedReader br = new BufferedReader(fr); 
FileWriter fw = new FileWriter("outfile.txt"); 
String line;

while((line = br.readLine()) != null)
{ 
    line = line.trim(); // remove leading and trailing whitespace
    if (!line.equals("")) // don't write out blank lines
    {
        fw.write(line, 0, line.length());
    }
} 
fr.close();
fw.close();