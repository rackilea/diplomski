public int hashCode() {
  int result = 17;
  result = 31 * result + numero;
  result = 31 * result + fornitura;
  if (film != null) {
    result = 31 * result + film.hashCode();
  }
  return result;
}