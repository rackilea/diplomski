CSVWriter writer = null;
try 
{
    writer = new CSVWriter(new FileWriter("/sdcard/myfile.csv"), ',');
    String[] entries = "first#second#third".split("#"); // array of your values
    writer.writeNext(entries);  
    writer.close();
} 
catch (IOException e)
{
    //error
}