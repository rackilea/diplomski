public class MyObject {

    public void merge( MyObject that ) {
        // given some other instance of an object merge this with that.
        // write your code here, and you can figure out the rules for which values win.
    }
}

ObjectInputStream stream = new ObjectInputStream( new FileInputStream( file ) );
MyObject that = stream.readObject();
someObject.merge( that );