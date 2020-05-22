XMLMemento memento = XMLMemento.createWriteRoot("root");

 ... add your entries

try (Writer writer = new OutputStreamWriter(new FileOutputStream("file name"), StandardCharsets.UTF_8)) 
 {
    memento.save(writer);
 }