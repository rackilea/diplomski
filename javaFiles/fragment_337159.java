try (Reader reader = new InputStreamReader(new FileInputStream("file name"), StandardCharsets.UTF_8)) 
 {
   IMemento memento = XMLMemento.createReadRoot(reader);

   ... read the memento contents
 }