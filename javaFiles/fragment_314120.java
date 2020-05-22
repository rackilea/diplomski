class Externalization { 

  int foo = 0; 

  void method() { 
    jni(); // external action
    foo = 42; 
  } 

  native void jni(); /* { 
    assert foo == 0; 
  } */ 
}