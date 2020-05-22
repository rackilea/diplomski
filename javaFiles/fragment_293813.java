class Test {
  i; // <-- Uncaught SyntaxError: Unexpected token ;
  method() {
    console.log(i);
  }
}