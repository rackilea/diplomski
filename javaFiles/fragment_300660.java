public class Rotation45 {
    public static void main(String[] args) throws IOException {
        String filename =     "bank-full2.csv";

        File file = new File(filename);
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new      FileWriter("bank2test1.csv"));     
            double a1 = 0.866025;
            double a2 = 0.5;
            double a3 = -0.5;
            double a4 = 0.866025;
            double b1;
            double b2;
            double c1;
            double c2;        

            String line1= null;
            String line2 = null;
            // Skeeps the head line
            reader.readLine();

            String currentLine = null;

            while (  ((line1 = reader.readLine())!= null) && ((line2 =     reader.readLine()) != null)       ) {

                String[] values = line1.split(","); 

                double first = Double.parseDouble(values[2]);

                String[] values1 = line2.split(","); 

                double second = Double.parseDouble(values1[2]);

                c1 = ((a2 * second) + (a1 * first));
                c2 = ((a3 * first) + (a4 * second));
                values1[2] = String.valueOf(c2);
                values[2] = String.valueOf(c1);
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < values.length; i++) {
                    sb.append(values[i]);
                    if (i < values.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append("\n");
                for (int i = 0; i < values1.length; i++) {
                    sb.append(values1[i]);
                    if (i < values.length - 1) {
                        sb.append(",");
                    }
                }

                writer.write(sb.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
            reader.close();

        } catch(FileNotFoundException ex) {
            Logger.getLogger(Rotation45.class.getName()).log(Level.SEVERE,      null, ex);
        }
    }
}