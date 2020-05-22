Scanner words= new Scanner(new FileReader("myfile.txt"));

while (words.hasNext())
{
    String fileWord= words.next();
    if (fileWord.equals(cellValue )) // check if the Cell value equals the word in text file
    {
        // do your code.. write data to desired cell. use setCellValue() method.

    }
}