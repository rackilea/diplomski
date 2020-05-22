NodeVisitor linkvisitor = new NodeVisitor() {
  public void visitTag(Tag tag) {
    if (tag.getTagName().equals("SCRIPT")) {
      ScriptTag script = (ScriptTag)tag;
      String srcValue = script.getAttribute("src");
      String text = script.getStringText();
    }
  }
};