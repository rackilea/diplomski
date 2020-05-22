@SuppressWarnings("unchecked")
public AtomicLongMap<String> readFromFile(File file) throws IOException, ClassNotFoundException { 

    try(FileInputStream fis = new FileInputStream(file);

        ObjectInputStream ois = new ObjectInputStream(fis);) {


    Map<String,Long>readObj = (Map<String, Long>)ois.readObject();

    return AtomicLongMap.create(readObj);

    }


  }