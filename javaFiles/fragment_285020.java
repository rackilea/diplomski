public class UnivocityTest
{

    public static void main(String[] args) throws FileNotFoundException
    {
        // Get data from csv file1
        List<String[]> f1 = getData("example.csv");
        // Get data from csv file2


       List<String[]> f2 = getData("example1.csv");

        // Convert data to a Map with HeaderList class and entire row.
        Map<HeaderList, String[]> map1 = convertAndReturn(f1);
        Map<HeaderList, String[]> map2 = convertAndReturn(f2);

        //Currently prints the required rows.
        compareData(map1, map2);
    }

    // Convert csv to List<String[]>
    private static List<String[]> getData(String file) throws FileNotFoundException
    {
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setLineSeparatorDetectionEnabled(true);
        RowListProcessor rowProcessor = new RowListProcessor();
        parserSettings.setProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);
        parser.parse(getReader(file));
        // String[] headers = rowProcessor.getHeaders();
        List<String[]> rows = rowProcessor.getRows();

        return rows;
    }

    // get reader object
    private static Reader getReader(String string) throws FileNotFoundException
    {
        // TODO Add proper file handling and exception handling
        return new FileReader(new File(string));
    }

    // Return HashMap
    private static Map<HeaderList, String[]> convertAndReturn(List<String[]> f1)
    {
        Map<HeaderList, String[]> map = new java.util.HashMap<>();

        for (String[] each : f1)
        {
            // For each row in csv create a corresponding HeaderList object with h1,h2 and h3 as key
            // and row as value.
            HeaderList header = new HeaderList(each[0], each[1], each[2]);
            map.put(header, each);
        }

        return map;
    }

    private static void compareData(Map<HeaderList, String[]> map1, Map<HeaderList, String[]> map2)
    {
        // Iterates over the map1 keys one by one. For each key we check if there is a matching key
        // in map2. The matching condition will be h1 and h2 should be same while h3 should be
        // different. Once a key like that is found currently I'm printing both the rows, here you
        // can get the rows you want from the map and return them.

        for (HeaderList each : map1.keySet())
        {
            if (map2.containsKey(each))
            {
//TODO Assume you want columns h3,h4 from file1 and h6  h7 from file2.
                //We know map1 represents file1 with columns h3 and h4 at positions 2 and 3 inside the String[]
                //We know map2 represents file1 with columns h6 and h7 at positions 3 and 4 inside the String[]
                String h3FromFile1 = map1.get(each)[2];
                String h4FromFile1 = map1.get(each)[3];
                String h6FromFile2 = map2.get(each)[3];
                String h7FromFile2 = map2.get(each)[4];
                System.out.println("Required Columns: ");
                System.out.println("h3 file1: "+ h3FromFile1);
                System.out.println("h4 file1: "+ h4FromFile1);
                System.out.println("h6 file2: "+ h6FromFile2);
                System.out.println("h7 file2: " + h7FromFile2);
                System.out.println(Arrays.toString(map1.get(each)));
                System.out.println(Arrays.toString(map2.get(each)));
                System.out.println("-------------------------------");
            }
        }
    }

}