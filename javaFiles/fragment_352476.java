XSLFTable t = null;
for (XSLFShape shape : slide) {
    if (shape instanceof XSLFTable) {
        t = (XSLFTable) shape;
        r = t.getRows();
   }
}