File fileToSaveObject=new File("path");
Object objectToSave=new Object();

FileOutputStream fileOut = new FileOutputStream(fileToSaveObject);
ObjectOutputStream out = new ObjectOutputStream(fileOut);

out.writeObject(objectToSave); // It will save 'objectToSave' in given file

out.close();
fileOut.close();