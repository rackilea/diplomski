WebDriver firefoxDriver=new FirefoxDriver();
try {
    BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "Cp1252"));         
    String websiteLink;
    while ((websiteLink = reader.readLine()) != null) {
        long start = System.currentTimeMillis();
        firefoxDriver.get(websiteLink);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start; 
        System.out.println("Total Time for page load - "+(totalTime/1000)+"s");
    }
    reader.close();

} catch (IOException e) {
    e.printStackTrace();
}