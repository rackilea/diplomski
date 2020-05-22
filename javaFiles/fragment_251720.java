public static ArrayList<Object> load(Context ctx, String filename) throws FileNotFoundException {
    InputStream instream = ctx.openFileInput(filename);

    ArrayList<Object> objects = new ArrayList<Object>();

    try {
        ObjectInputStream ois = new ObjectInputStream(instream);
        try{
            Object loadedObj = null;
            while ((loadedObj = ois.readObject()) != null) {
                objects.add(loadedObj);
            }

            return objects;
        }finally{
            ois.close();
        }

    } catch (StreamCorruptedException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}