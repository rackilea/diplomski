@Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity that = (Entity) o;
    return Objects.equals(getA(), that.getA())
        && Objects.equals(getB(), that.getB())
        && Objects.equals(getC(), that.getC()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(getA(), getB(), getC());
  }