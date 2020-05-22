int main() {
  R r;
  P & p = r;
  B b;
  r.f( b ); // [1] calls R::f( B& )
  p.f( b ); // [2] calls R::f( A& )
}