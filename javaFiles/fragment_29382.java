class Foo {
  T field;

  T method()
  {
     ....
     try {
       ....
       return field;
     } finally {
       field = null;
     }
  }
}