public class MyObject{
    private static long ID_INCREMENTOR = 0;
    private long id;
    public MyObject(){

          ID_INCREMENTOR++;
          id = ID_INCREMENTOR;

    }

public long getID(){
    return id;
}

/* Other methods and such */
}