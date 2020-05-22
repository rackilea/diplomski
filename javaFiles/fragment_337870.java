Test.java:17: warning: [unchecked] unchecked conversion
                List<? super Date> data = cont.get(0);  // [2]
                                                  ^
  required: List<? super Date>
  found:    CAP#1
  where CAP#1 is a fresh type-variable:
    CAP#1 extends List from capture of ? extends List
1 warning