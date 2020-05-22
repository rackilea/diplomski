> List<A> list = new ArrayList<? extends A>();
Error:
unexpected type
  required: class or interface without bounds
  found:    ? extends A

> List<? extends A> list = new ArrayList<A>();
[]