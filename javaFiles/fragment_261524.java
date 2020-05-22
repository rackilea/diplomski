public static String[] getFileContents(String path) throws FileNotFoundException, IOException
    {
        InputStream in = new FileInputStream(new File(path));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> data = new ArrayList<String>();
        StringBuilder out = new StringBuilder();
        String line;
//        Skips 1376 characters before accessing data
        reader.skip(1378);
        while ((line = reader.readLine()) != null) {            
                data.add(line);
//                System.out.println(line);
        }  
        List<Point> points = new ArrayList<Point>();
        for (int i=0; i < data.size(); i++){
            double lat =  Double.parseDouble(data.get(i).split(",")[0]);

            double len =  Double.parseDouble(data.get(i).split(",")[1]);
            points.add(new Point(lat, len));
            //data.set(i, data.get(i).split(","));
        }
//        String[] dataArr = data.toArray(new String[data.size()]);
//        Test that dataArr[0] is correct
//        System.out.println(data.size()); 
//        List<String> formattedData = new ArrayList<String>();
//        for (int i = 0; i < data.size(); i++){
//            formattedData.add(dataArr[i].split(","));
//        }
        reader.close(); 
        return dataArr;
    }