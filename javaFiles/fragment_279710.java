private static PersonDetails parseLine(String line, String deliminator, 
                         SectionsReader reader) throws Exception 
{
    reader.setLine(line);
    String value1 = reader.getValue1();
    String value2 = reader.getValue2();
    String value3 = reader.getValue3();
    String value4 = reader.getValue4();
    String value5 = reader.getValue5();

    //........
}