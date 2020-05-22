public class DispatcherJsonAction extends ActionSupport {

    private Book book;

    @Action("dispatcherJson")
    @Result(name = ActionSupport.SUCCESS, location = "page.jsp")        
    public String execute(){
        book = loadBookSomeHow();
        return SUCCESS;
    }

    public String getJsonBook(){
        Gson gson = new Gson();
        try {
            return gson.toJson(book);
        } catch (Exception e){
            return gson.toJson(e.getMessage());
        }
    }

}