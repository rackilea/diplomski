public static String readArabic(String path) throws FileNotFoundException {

    StringBuilder add = new StringBuilder();
    try(BufferedReader red = new BufferedReader(new FileReader(path));) {
        String out;
        while ((out = red.readLine()) != null){
            //System.out.println(out);
            add.append(out);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return String.valueOf(add);
}