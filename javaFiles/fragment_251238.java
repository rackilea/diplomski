public <E> E read() {
    Objject obj;
    E object = null;
    try {
          obj = reader.readObject();
          System.out.println(obj.getClass().getName())       
          object = (E) obj;
    } catch (ClassNotFoundException ex) {
        System.err.println("Class dont found");
        System.err.println(ex);
    } catch (IOException ex) {
        System.err.println("End of the file");
        System.err.println(ex);
    } catch (ClassCastException ex) {
        System.err.println("Class dont found");
    }
    return object;
}