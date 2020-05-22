IPcdContext context;
Object obj = context.lookup("foo");
if (obj instanceof IPcdContext) {
    context = (IPcdContext)obj;
}
else {
    // You got back something else.  What to do?
}