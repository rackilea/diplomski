public abstract class AbstractImporter {

    public AbstractImporter() {
        // Initialization
    }

    public abstract void run();
}

public class ConcreteImporter1 extends AbstractImporter {
    public void run() {
        //do something
    }
}


public class ImporterMain() {

    public static void main(String[] args) {
        AbstractImporter importer = createImporter(args[1]);
        importer.run();
    }

    private static AbstractImporter createImporter(String type) {
        if (type.equals("1")) {
            return new ConcreteImporter1();
        }
        ....
    }
}