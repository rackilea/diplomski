public static ArrayList<String> readList(Context c){//
    try{
        FileInputStream fis = c.openFileInput("NAME");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<String> list = (ArrayList<String>)is.readObject();
        is.close();
        return list;
    }catch(Exception ex){
        ex.printStackTrace();
        return null;
    }               
}

public static void writeList(Context c, ArrayList<String> list){
    try{
        FileOutputStream fos = c.openFileOutput("NAME", Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(list);
        os.close();
    }catch(Exception ex){
        ex.printStackTrace();
    }
}