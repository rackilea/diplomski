// FTPClient ftp = new FTPClient(); Assumed in your code
//Connect to the server 
try
{
    ftp.connect(host);
    replyText = ftp.getReplyString();
    System.out.println(replyText);
} catch (Exception  e)  { e.printStackTrace () ; }

//Login to the server 
try 
{ 
    ftp.login(userId, password);
    replyText = ftp.getReplyString();
    System.out.println(replyText);
} catch (Exception e) { e.printStackTrace(); } 

// Tell the server to use the JES interface
try
{ 
    // Instead of sendSiteCommand()
    // ftp.sendSiteCommand("FILETYPE=JES");

    // Try site() with everythng in lowercase
    ftp.site ("filetype=jes") ; 
    String replyText = ftp.getReplyString() ; 
    System.out.println (replyText) ; 
} catch (Exception e) { e.printStackTrace(); } 

//Submit the job from the text file.Use \\ to avoid using escape notation 
try 
{ 
    //read JCL file in input stream
    //String originalFileName = "ca7jcl.txt";

    String path = "" //Store your file's absolute path here 
    FileInputStream fileStream = new FileInputStream(path);

    //store the JCL file
    ftp.storeFile(host, fileStream);
    replyText = ftp.getReplyString();
    System.out.println(replyText);
 }  catch (Exception e) { e.printStackTrace(); }