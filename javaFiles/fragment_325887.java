DataObject.Registry registries = DataObject.getRegistry();
registries.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        System.out.println("ChangedListener: o = " + e.getSource().getClass());
        System.out.println("ChangedListener: o.source = " + e.getSource());
    }
});
DataObject[] objects = registries.getModified();
for (int i = 0; i < objects.length; i++) {
    DataObject dataObj = objects[I];
    System.out.println("data object name = " + dataObj.getName());
    System.out.println("data object pimary file name = " + dataObj.getPrimaryFile().getName());
    Set fss = dataObj.files();
    Iterator iter = fss.iterator();
    while (iter.hasNext()) {
        FileObject fo = (FileObject) iter.next();
        System.out.println("\tset file object: " + fo.getName());
    }
}