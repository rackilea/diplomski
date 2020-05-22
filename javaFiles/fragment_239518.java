class book {
    private String name = null;
    private int page = 0;

    book(String name, int page) {
        this.name = name;
        this.page = page;
    }

    String getName() {
        return this.name;
    }

    int getPage() {
        return this.page;
    } 
}

public class example {  
    public static void main(String[] args) {
        book b1 = new book("book1", 300);
        System.out.println(b1.getName());
        System.out.println(b1.getPage());
        System.out.println();
    }
}