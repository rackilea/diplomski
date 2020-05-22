Rectangle r = child.getVisibleRect();
if (r.getSize().equals(child.getSize() {
   // fully visible
} else if (r.isEmpty()) {
   // not visible
} else {
  // partly visible
}