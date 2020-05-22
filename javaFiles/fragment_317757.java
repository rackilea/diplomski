// Create the list of new tag names
final List<String> names = Arrays.asList("Name1", "Name2", "Name3");
final Document doc = ...

// Find all <R/> elements and iterate over their <C/> children
$(doc).find("R").children("C").each(new Each() {
  public void each(Context context) {

    // Get the appropriate tag name corresponding to the iteration index
    String newTagName = names.get(context.elementIndex() % names.size());

    // Use the DOM API to rename the node
    doc.renameNode(context.element(), "", newTagName);
  }
});

// Check results
System.out.println($(doc));