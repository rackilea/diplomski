public static void readArabic(String path) throws FileNotFoundException {


        try(BufferedReader red = new BufferedReader(new FileReader(path));) {
            String out;
            while ((out = red.readLine()) != null){
                System.out.println(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }