while (fieldsIterator.hasNext()) {
    field = fieldsIterator.next();
    this.lastKey = field.getKey();
    location += "/" + this.lastKey;
    processNode(field.getValue(), currentPath + "/" + this.lastKey);
}