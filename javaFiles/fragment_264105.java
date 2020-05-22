public int next_token() throws java.io.IOException {
...
if (c) {
  // sometimes returns a Symbol
  return new java_cup.runtime.Symbol(sym.EOF);
} else {
  // sometimes returns an int
  return sym.identifier;
}