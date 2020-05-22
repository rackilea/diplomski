struct A {};
struct B : A {};
struct C {
   virtual void f( B& );
};
struct D : C {
   virtual void f( A& );     // this would be contravariance, but not supported
   virtual void f( B& b ) {  // [0] manually dispatch and simulate contravariance
      D::f( static_cast<A&>(b) );
   }
};