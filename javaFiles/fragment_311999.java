public class PointGenterate {

    public static void main(String[] args) throws Exception {
        try {
            File file = new File("123.txt");
            double[] pointsid = new double[10];
            String[] data = null;

            for(int i = 0; i < 10; i++){
                double rn = (int)(Math.random()*120);
                System.out.println(rn);
                pointsid[i] = rn;
            }

            //read file
            InputStreamReader rs = new InputStreamReader(new FileInputStream(file));//create input stream reader object
            BufferedReader br = new BufferedReader(rs);
            String line = "";

            //
            File write = new File("output.KML");
            write.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(write));
            while((line = br.readLine()) != null){ // read the line and check for null
                if(line.isEmpty()) { // is the line equal to the empty string?
                    System.out.print("empty");
                } else {
                    data = line.split(",|:|[|]");
                }

                for(int i = 0; i < data.length; i++){
                    data[i] = data[i].trim();
                    System.out.println(data[i] + "num" + i);
                }

                if(data.length > 15){
                    double id = Double.parseDouble(data[4]);
                    for(int i = 0; i <10; i++){
                        if(id == pointsid[i]){
                            data[10] = data[10].substring(0, data[10].length()-2);
                            data[15] = data[15].substring(1,data[15].length());
                            data[16] = data[16].substring(0, data[16].length()-6);
                            out.write(data[8]+" "+ data[10]+ " " + data[13] + data[15] + data[16]+ "\r\n");
                            out.flush();
                        }
                    }
                }
                //System.out.println(line);
            }
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();            
        }
    }
}