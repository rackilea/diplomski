class GrandFather {
  GrandFather(String name, boolean configure) {
    // some init
    if (configure) {
      configure(name);
    }
  }

  GrandFather(String name) {
    this(name, true);
  }
}

class Father {
  Father(String name, boolean configure) {
    super(name, false);

    // some init
    if (configure) {
      configure(name);
    }
  }

  Father(String name) {
    this(name, true);
  }
}

class Son {
  Son(String name, boolean configure) {
    super(name, false);

    // some init
    if (configure) {
      configure(name);
    }
  }

  Son(String name) {
    this(name, true);
  }
}