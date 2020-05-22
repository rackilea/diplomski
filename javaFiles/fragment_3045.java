struct D : C {
   using C::f;           // Bring all overloads of `f` in `C` into scope here
   virtual void f( A& );
};
int main() {
   D d; B b;
   d.f( b );  // C::f( B& ) since it is a better match than D::f( A& )
}