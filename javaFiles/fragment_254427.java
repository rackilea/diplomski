IJavaElement je = b.getJavaElement();
while (je != null && !(je instanceof ITypeRoot)) {
    je = je.getParent();
}
if (je != null) {
    ITypeRoot = (ITypeRoot)je;
    //...
}