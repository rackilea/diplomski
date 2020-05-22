public class ProjectPostAction {
 private int authorId;
 private InputStream inputStream;

 public final InputStream getInputStream() {
  return inputStream;
 }

 public final void setInputStream(InputStream inputStream) {
  this.inputStream = inputStream;
 }


 public final int getAuthorId() {
  return authorId;
 }

 public final void setAuthorId(int authorId) {
  this.authorId = authorId;
 }


public String getBooks() throws DAOTransientException, DBConfigException{
  
  BookDao bookDao = new BookDao();
  List <Book> bookList = bookDao.getBooks(this.authorId);
  
  String bookListByAuthorId = "<select name="bookListByAuthorId">";

  for(int i=0; i<bookList.size(); i++){
            bookListByAuthorId += "<option value='" + i + "'>" + bookList.get(i).getName() + "</option>";
        }

  bookListByAuthorId += "</select>";
  inputStream = new StringBufferInputStream(bookListByAuthorId);

  return "success";  
 }
......................

}

/////////////////////////////////////////////

<action name="getBooks" class="#myActionClass" method="getBooks">
   <result name="success" type="stream">
   <param name="contentType">text/html</param>
            <param name="inputName">inputStream</param>
         </result>
   <result name="failure">./failure.jsp</result>
   <result name="error">./error.jsp</result>
  </action>