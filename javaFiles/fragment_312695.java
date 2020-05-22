import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class Main {

    public static final class Tree implements Serializable {

        public final ArrayList<Tree> branches = new ArrayList<>();
        private final boolean isRoot = ROOT == null;

        private Object readResolve() throws ObjectStreamException {
            if(isRoot)
                return ROOT;
            else
                return this;
        }
    }

    public static final Tree ROOT = new Tree();

    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/Stephen/Desktop/temp.bin");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(ROOT);
        oout.writeObject(ROOT);
        oout.close();
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Tree t1 = (Tree) oin.readObject();
        Tree t2 = (Tree) oin.readObject();
        oin.close();
        System.out.println(ROOT == t1); // true
        System.out.println(t1 == t2); // true
    }
}