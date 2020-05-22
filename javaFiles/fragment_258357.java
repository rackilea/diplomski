public static void main(String[] args) throws FileNotFoundException 
{
    //Change the path for the file
    String content = new Scanner(new File("/home/santhoshkumar/Desktop/sample.xml")).useDelimiter("\\Z").next();

    //System.out.println(content);

    Pattern pattern = Pattern.compile("<SupplierPartID>(.*)</SupplierPartID>");    
    Matcher matcher = pattern.matcher(content);  

    while (matcher.find()) 
    {    
        System.out.println(matcher.group(1));    

    }    
}