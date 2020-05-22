FileInputStream fis = new FileInputStream("outputFile");
ArrayList<Object> objectsList = new ArrayList<>();
boolean cont = true;
while (cont) {
  try (ObjectInputStream input = new ObjectInputStream(fis)) {
    Object obj = input.readObject();
    if (obj != null) {
      objectsList.add(obj);
    } else {
      cont = false;
    }
  } catch (Exception e) {
    // System.out.println(e.printStackTrace());
  }
}