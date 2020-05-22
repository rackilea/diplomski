public static void main(String[] args) throws FileNotFoundException 
{
    String fileName = "Numbers.txt";

    readFile myClass = new readFile(fileName);
    myClass.readArray();
    myClass.findLowest();
    myClass.findHighest();
    myClass.findTotalNum();
    myClass.findAverage();
}