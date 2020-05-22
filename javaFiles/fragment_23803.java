public class Convert {

    static final String[] headers = {"UUID","location","name","age"};


    public static void main(String[] args) throws IOException {

        List<Data> dataList = new ArrayList<Data>();
        LineNumberReader r = new LineNumberReader(new FileReader("test.csv"));

        String line = r.readLine();
        while(line != null){
            String[] dataArray = line.split(",");
            for(String record:dataArray){
                String[] elements = record.split("\\|");
                Data data = new Data(elements);
                //If you dont want to accumulate data then you can stream xml out. 
                dataList.add(data);
            }
            line = r.readLine();
        }
        r.close();

        // now use your favorite xml library to stream out. I use xstream. in your case even direct constructing xml seems ok too. 
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("data", Data.class);
        xstream.toXML(dataList, System.out);

        //if you want formatted xml then use PrettyPrintWriter..
/*      BufferedOutputStream stdout = new BufferedOutputStream(System.out);
        PrettyPrintWriter p = new PrettyPrintWriter(new OutputStreamWriter(stdout));
        xstream.marshal(dataList, p);
*/      
    }

}