public class Page{
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "book_id")
     public Book book;

     @PreRemove
     private void preRemove() {
         if (book != null) {
               throw new BookRelationShipExist();
         }
     }
 }