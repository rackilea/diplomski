-------- 
A -->| Object |<-- B
      --------

A.id = 10; // Property of object modified
B.id = 10; // Property of object modified here also

B = null ; // B is set to null
      -------- 
A -->| Object |     B (reference is null)
      --------