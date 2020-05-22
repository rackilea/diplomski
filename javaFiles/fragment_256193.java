public class Foo {
  private ArrayList<String> names;
    public void scan() {
      synchronized (this)
        if (names == null) {
           this.names = new ArrayList<String>();
           // fill the array with data
         }
       }
     }
  }