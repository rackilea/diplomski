public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((product == null) ? 0 : product.hashCode());
  result = prime * result + ((user == null) ? 0 : user.hashCode());
  return result;
}