NamingEnumeration<Binding> contentsEnum = ctx.listBindings(n2);

String[] attName = {"cn"};

while ( contentsEnum.hasNext() ) {
    Binding binding = contentsEnum.next();
    Object o = binding.getObject();
    // etc, whatever you were intending to do with the result of lookup(), which is now in 'o'.
}