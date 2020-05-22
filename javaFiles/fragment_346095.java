File folder = new File(path);
File[] listOfFiles = folder.listFiles();
FileWriter fstream = new FileWriter("dataset.txt");
BufferedWriter br= new BufferedWriter(fstream);

for (int i = 0; i < listOfFiles.length; i++)  
{
    try 
    {
       Document doc = new DomSerializer(props, true).createDOM(tagNode);
    } 
      catch (DOMException de) 
      {
         de.printStackTrace();
      }
}