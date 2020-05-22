// assuming that contravariance was supported:
struct P {
   virtual f( B& ); 
};
struct Q : P {
   virtual f( A& );
};
struct R : Q {
   virtual f( ??? & );
};