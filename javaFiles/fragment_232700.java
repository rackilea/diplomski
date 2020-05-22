Object[] args= new Object[4];
args[0]= setOfItems;
args[1]= aString;
args[2]= document;
args[3]= profiler;

Method m = this.getClass().getMethod("xyz", Set.class, String.class, Document.class, Profiler.class);
Object result = proxy.invoke(m, this, args)