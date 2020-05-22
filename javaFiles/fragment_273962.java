//Open the Word Document                                 
Document doc = new Document("C:\\Data\\Image2.doc");     

//Get page count                                         
int pageCount = doc.getPageCount();

//Print Page Count            
System.out.println(pageCount);