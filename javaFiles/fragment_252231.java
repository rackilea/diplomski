Properties properties = new Properties();
try 
{
    properties.load(new FileInputStream("C://email_template.properties")); //specify path here
    String sServerLocation = properties.getProperty("image_server");
    String sImageFolder = properties.getProperty("image_folder");
    StringBuilder strEmail = new StringBuilder();
    strEmail.append("<html><body> <img src=\"" + sServerLocation + sImageFolder +"birthday.jsp\""> </body> </html>" );   
    // Write code to generate complete email dynamically
    // write code to send out the email or to save as html file to you machine, where you can send it manually.