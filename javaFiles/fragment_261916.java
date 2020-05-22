@Component
public class RunCode {

    private final RepositoryInterface repositoryInterface;

    public RunCode(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @PostConstruct
    public void doSomething() {
       // updateAsList();
        updateOneByOne();
    }

    private void updateOneByOne() {
        List<Book> books = createBookList();
        for(int i=0;i<books.size();i++){
            repositoryInterface.save(books.get(i));
        }
    }

    private void updateAsList() {
        List<Book> books = createBookList();

        for (int i = 0; i < books.size(); i++) {
            switch (i) {
                case 0:
                    books.get(0).setBookNumber(00);
                    break;
                case 1:
                    books.get(1).setBookNumber(11);
                    break;
                default:
                    System.out.println("nothing per this example");
            }
        }

        repositoryInterface.save(books);
    }

    private List<Book> createBookList() {
        List<Book> books = new ArrayList<>();
        Book book0 = new Book();
        book0.setBookName("Book0");
        book0.setBookNumber(0);

        books.add(book0);

        Book book1 = new Book();
        book1.setBookName("Book1");
        book1.setBookNumber(1);

        books.add(book1);
        return books;
    }
}