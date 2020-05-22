// This method is called immediately after the object is created and before the unmarshalling of this 
   // object begins. The callback provides an opportunity to initialize JavaBean properties prior to unmarshalling.
   void beforeUnmarshal(Unmarshaller, Object parent);

   //This method is called after all the properties (except IDREF) are unmarshalled for this object, 
   //but before this object is set to the parent object.
   void afterUnmarshal(Unmarshaller, Object parent);