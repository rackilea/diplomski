class SomePoolJavaUses {
   static Long _l1 = new Long(1L);
   static Long _l2 = new Long(2L);
   static Long _l3 = new Long(3L);
   ...
}

Long v1 = SomePoolJavaUses._l1;
Long v2 = SomePoolJavaUses._l1;
Double d1 = new Double(1.0);
Double d2 = new Double(1.0);