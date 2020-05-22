struct BaseClass 
{     
   //... 
};  
struct DerivedClass 
{     
   struct BaseClass super;     
   //....  
};  

struct DerivedClass d; 
//UpCasting example  
struct BaseClass *base_ptr = (struct BaseClass *)&d; 
//Downclasting Example 
struct DerivedClass *derived_ptr = (struct DerivedClass *)base_ptr;