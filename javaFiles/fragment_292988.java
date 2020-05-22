class Proxy extends Hello {
  Hello target;

  void print() {
     target.print();
  }
}