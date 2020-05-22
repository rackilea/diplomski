private String buildImportQuery(File f, String nomeArq) {
    StringBuilder sb = new StringBuilder();
    try {
        //Reads the file
        FileReader fileReader = new FileReader(f);
        BufferedReader buffer = new BufferedReader(fileReader);
        String line;

        sb.append("INSERT INTO " + nomeArq +  " (codigo) VALUES ");
        boolean addComma = false;
        while ((line = buffer.readLine()) != null) {
            if(line.length() > 0) {
                if(addComma) {
                    sb.append(",");
                }
                sb.append("('" + line.trim() + "')");
                addComma = true;
            }
        }
        sb.append(";");
    } catch (IOException e) {
        Toast.makeText(this, "Could not write query. " + e.getMessage(), Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }

    return sb.toString();

}