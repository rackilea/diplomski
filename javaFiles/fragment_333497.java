private static String LFILE = "serial";

public static void updateFile(Double num) {

    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    try{
        List<Double> list = getDoubles();
        list.add(num);
        fos = new FileOutputStream(LFILE);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(list);

    }catch(Exception e){
        e.printStackTrace();
        try {
            oos.close();
            fos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}

public static List<Double> getDoubles() {

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    List<Double> newList = new ArrayList<Double>();
    try {
        fis = new FileInputStream(LFILE);
        ois = new ObjectInputStream(fis);

        newList = (ArrayList<Double>) ois.readObject();

    } catch (Exception ex) {

        try {
            fis.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return newList;
}