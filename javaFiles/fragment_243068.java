public static Basis complimentary(Basis subject) {
  if (subject == Basis.RECTILINEAR)
  {
    return Basis.DIAGONAL;
  }
  else
  {
    return Basis.RECTILINEAR;
  }
}
…
Basis.complimentary(Basis.DIAGONAL); // RECTILINEAR