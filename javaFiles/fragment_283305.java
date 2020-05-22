public static void main(String[] args) {
    // The path of your YAML file.
    final String fileName = "test.yml";
    ArrayList<String> key = new ArrayList<String>();
    ArrayList<String> value = new ArrayList<String>();
    ArrayList<Object> obj = new ArrayList<Object>();
    ArrayList<Object> objected = new ArrayList<Object>();
    opencvmatrix obj1 = new opencvmatrix();
    opencvmatrix obj2 = new opencvmatrix();
    opencvmatrix obj3 = new opencvmatrix();
    opencvmatrix obj4 = new opencvmatrix();
    opencvmatrix obj5 = new opencvmatrix();
    ArrayList<opencvmatrix> objects = new ArrayList<opencvmatrix>();
    Yaml yaml = new Yaml();

    try {
        InputStream ios = new FileInputStream(new File(fileName));
        // Parse the YAML file and return the output as a series of Maps and Lists
        Map< String, Object> result = (Map< String, Object>) yaml.load(ios);
        for (Object name : result.keySet()) {
            key.add(name.toString());
            obj.add(result.get(name));                
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        obj1 =(opencvmatrix)(obj.get(0));
        obj2 =(opencvmatrix)(obj.get(1));
        obj3 =(opencvmatrix)(obj.get(2));
        objected.add((obj.get(3)));
        obj4 =(opencvmatrix)(obj.get(4));

        for (int i = 0; i < 3600; i++) {
            for (int j = 0; j < 19; j++) {

                System.out.print(obj3.data.get(i*j));
            }
            System.out.println();

        }



}