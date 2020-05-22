reader.moveDown(); // RootMapping
reader.moveDown(); // First FieldMap
A n = new A(reader,context);
reader.moveUp();
reader.moveUp();
return n;