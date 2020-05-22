34   public void getBookIds(int id) {
35      try {
36         book.getId(id);    // this method it throws a NullPointerException on line 22
37      } catch (NullPointerException e) {
38         throw new IllegalStateException("A book has a null property", e)
39      }
40   }