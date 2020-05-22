public Basis complimentary() {
  if (this == Basis.RECTILINEAR)
  {
    return Basis.DIAGONAL;
  }
  else
  {
    return Basis.RECTILINEAR;
  }
}
…
Basis.DIAGONAL.complimentary(); // RECTILINEAR