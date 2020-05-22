Main.java:19: warning: [unchecked] unchecked call to Tuple(K,V) as a member of the raw type Tuple
      return new Tuple("test", 8);
             ^
  where K,V are type-variables:
    K extends Object declared in class Tuple
    V extends Object declared in class Tuple
Main.java:26: warning: [unchecked] unchecked conversion
    Tuple<String, Bar> t = Test.f();
                                 ^
  required: Tuple<String,Bar>
  found:    Tuple
2 warnings