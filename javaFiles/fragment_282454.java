YourObject yourObject;
List<YourObject> listObject;
-----
public void aMethodInBean(SelectEvent event) {
    yourObject = (YourObject) event.getObject();
}