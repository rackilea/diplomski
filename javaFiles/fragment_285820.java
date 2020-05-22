try {
    fis1 = openFileInput("names");
    ois1 = new ObjectInputStream(fis1);
    names = (ArrayList<String>) ois1.readObject();

    // indicates if names is really null
    Log.i("names is ", (names == null) ? "null" : "not null"); 

    ois1.close();
    fis1.close();
}