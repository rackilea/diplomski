interface A {
  int run();
}

interface B {
  int stop();
  @property int status();
}

class X {
  int run() {
    return 1;
  }

  int stop() {
    return 2;
  }

  @property int status() {
    return 3;
  }
}

auto x = new X();

auto ab = x.wrap!(A, B);
A a = ab;
B b = ab;
assert(a.run() == 1);
assert(b.stop() == 2);
assert(b.status == 3);