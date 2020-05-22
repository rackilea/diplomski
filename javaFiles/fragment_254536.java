public class MyClass {
    private ArrayList < MyCustomObject > arrayList;
    private File dataFile;
    private String FILE_NAME = "FILE_DATA.dat";

    public void init(final Context context) {


        dataFile = new File("C:\\lompo\\file1.txt");

        if (dataFile.exists()) {
            loadData();

        } else {

            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            arrayList = new ArrayList < MyCustomObject > ();
            MyCustomObject obj1 = new MyCustomObject();
            obj1.aNumber = 125;
            obj1.myname = "HIS NAME";
            arrayList.add(obj1);
            saveData();
       }

    }

    public static void main(String[] args) {
        MyClass myClazz = new MyClass();
        myClazz.init(null);

        System.out.println("Arraylist has " + myClazz.arrayList.size() + " elements");
    }

    private void saveData() {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {

                ObjectOutputStream oos = null;
                try {

                    oos = new ObjectOutputStream(fos);

                    if (oos != null) {

                        oos.writeObject(arrayList);

                    }
                    assert oos != null;
                    oos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void loadData() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (fis != null) {

                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(fis);

                    if (ois != null) {

                        try {

                            arrayList = (ArrayList < MyCustomObject > ) ois.readObject();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                    assert ois != null;
                    ois.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}