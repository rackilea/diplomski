ObjectOutputStream oos = null;
try {
   oos = new ObjectOutputStream(new FileOutputStream(file));
   oos.writeObject(shapes);
   oos.flush();
} catch (FileNotFoundException ex) {
    // complain to user
} catch (IOException ex) {
    // notify user
} finally {
    if (oos != null) {
        try {
            oos.close();
        } catch (IOException ex) {
            // ignore ... any significant errors should already have been
            // reported via an IOException from the final flush.
        }
    }
}