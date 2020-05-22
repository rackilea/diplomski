public void readFeatureFile() {
    Path fpath= Paths.get("path to file").toAbsolutePath();
    String path = fpath.toString();
    String gherkin;
    try {

        gherkin = FixJava.readReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        System.out.println("gherkin...\n" + gherkin);
        StringBuilder json = new StringBuilder();
        System.out.println("json: '" + json + "'");
        JSONFormatter formatter = new JSONFormatter(json);
        System.out.println("formatter: " + formatter.toString());
        Parser parser = new Parser(formatter);
        System.out.println("parser: " + parser.toString());
        parser.parse(gherkin, path, 0);
        System.out.println("json: '" + json + "'"); 
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (RuntimeException e) {
        e.printStackTrace();
    }
}