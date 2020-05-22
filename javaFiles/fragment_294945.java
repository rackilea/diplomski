public void Serializuj( myTrip serTrip){
    FileOutputStream fos = null;
    try {
        File file = new File(getApplicationContext().getFilesDir(), "data.dat");
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream ou = new ObjectOutputStream(fo);
        ou.writeObject(serTrip);
        ou.close();
        fo.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public myTrip DeSerializuj() {
    myTrip   prvy = null;
    try {
        File file = new File(getApplication().getFilesDir(), "data.dat");
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream oi = new ObjectInputStream(fi);
     prvy = (myTrip) oi.readObject();
        oi.close();
        fi.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return prvy;
}