public class LectureCSV {

public static void main(String[] args) {
    try {
        String csvFile = "C:/Users/.../Downloads/file.csv";

        @SuppressWarnings("resource")
        CSVReader csvReader = new CSVReader(new FileReader(csvFile), ';');
        String[] col;
        float res = 0;
        while ((col = csvReader.readNext()) != null) {
            try {
                res = res + Float.parseFloat(col[1]);
            } catch (NumberFormatException e) {
            }
        }
        System.out.println(res);
    } catch (IOException ex) {
        Logger.getLogger(LectureCSV.class.getName()).log(Level.SEVERE,
                null, ex);
    }
}