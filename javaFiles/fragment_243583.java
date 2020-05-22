private void traverse(final Element element, final Visitor... visitors) {
   for (final Visitor visitor : visitors)
       // push e.g. the parent path to the stack
       visitor.push(visitor.visit(element)); 

   for (final Element child: getElementChildren(element))
       traverse(child, visitors);

   for (final Visitor visitor : visitors)
       visitor.pop();
}