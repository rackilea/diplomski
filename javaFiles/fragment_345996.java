public static void main(String[] args) throws IOException {

        FileOutputStream fosW = new FileOutputStream("/home/artur/tmp/test.csv");
        OutputStreamWriter osw = new OutputStreamWriter(fosW, "UTF-8");
        try (CSVWriter writerCSW = new CSVWriter(osw)) {

            String[] b = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                    "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ",
                    "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT" };

            System.out.println(b.length);
            for (int i = 0; i < b.length - 1; i++) {
                String a = "=IF(legend!" + b[i] + "$3='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$3,IF(legend!" + b[i] + "$4='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$4,IF(legend!" + b[i] + "$5='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$5,IF(legend!" + b[i] + "$6='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$6,IF(legend!" + b[i] + "$7='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$7,IF(legend!" + b[i] + "$8='Form responses 1'!" + b[i + 1] + "2,legend!" + b[i + 1]
                        + "$8,#error#))))))";
                String[] line = a.split(",");
                writerCSW.writeNext(line);
                System.out.println(i);
            }
        }

    }