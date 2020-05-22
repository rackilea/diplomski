class Pig {
    int a;

    Pig(int x) {
      a = x;
    }

    @Override
    public boolean equals(Object b) {
      if(b == null) return false;
      if(!(b instanceof Pig)) return false;
      if(b == this) return true;
      return ((Pig) b).a == a;
    }

    @Override
    public int hashCode() {
      return a;
    }
  }