try {
    Log.i("CHECKPOINT", "1");
    fis1 = openFileInput("names");
    Log.i("CHECKPOINT", "2");
    ois1 = new ObjectInputStream(fis1);
    Log.i("CHECKPOINT", "3");
    names = (ArrayList<String>) ois1.readObject();
    Log.i("CHECKPOINT", "4");
    ois1.close();
    Log.i("CHECKPOINT", "5");
    fis1.close();
    Log.i("CHECKPOINT", "6");
}