public void serializeData(String filename, ArrayList<SocialProfile>arrayList) {
    FileOutputStream fos;
    try {
        fos = openFileOutput(filename, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayList);
        oos.flush();
        oos.close();
    } catch (FileNotFoundException e) {
        ...
    }catch(IOException e){
        ...
    }
}

private ArrayList<SocialProfile> deserializeData(String filename){
    try{
        FileInputStream fis = openFileInput(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ArrayList<SocialProfile>)ois.readObject();
    } catch (FileNotFoundException e) {
        ...
    }catch(IOException e){
        ...
    }catch(ClassNotFoundException e){
        ...
    }
}