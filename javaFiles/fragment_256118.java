public static void main(String[] args) {
    BufferedReader in=null;
    List<Integer> velocityList = new ArrayList<Integer>(); 
    List<Integer> altitudeList = new ArrayList<Integer>();
    List<Double> latitudeList = new ArrayList<Double>();
    List<Double> longitudeList = new ArrayList<Double>(); 
    try {
        File file = new File("D:\\test.txt");
        FileReader reader = new FileReader(file);
        in = new BufferedReader(reader);
        String string;
        String [] inputs;
        while ((string = in.readLine()) != null) {
            inputs = string.split("\\s");
            //here is where we copy the data from the file to the data stucture
            if(inputs!=null && inputs.length==4){
                velocityList.add(Integer.parseInt(inputs[0]));
                altitudeList.add(Integer.parseInt(inputs[1]));
                latitudeList.add(Double.parseDouble(inputs[2]));
                longitudeList.add(Double.parseDouble(inputs[3]));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally{
        try {
            if(in!=null){
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //here are the arrays you want!!!
    Integer [] velocities = (Integer[]) velocityList.toArray();
    Integer [] altitiudes = (Integer[]) altitudeList.toArray();
    Double [] longitudes = (Double[]) longitudeList.toArray();
    Double [] latitudes = (Double[]) latitudeList.toArray();
}