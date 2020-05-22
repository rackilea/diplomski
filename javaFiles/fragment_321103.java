@ManagedBean
@ViewScoped
public class BookController {
    private DataModel<BookDTO> bookModel;
    private BookDTO book;

    public String viewBook() {
        book = bookModel.getRowData();   
        return "BookView";
    }

    // ...
}