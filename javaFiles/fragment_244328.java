String s = "";
Object o = s;
Class<? extends String> sc = s.getClass(); // ok
Class<? extends Object> oc = o.getClass(); // ok
oc = sc; // ok
sc = o.getClass(); // not ok
sc = oc; // not ok