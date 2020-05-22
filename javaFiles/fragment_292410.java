MultiplierImpl servant = new MultiplierImpl();
POA rootPOA = /* obtain a reference to the Root Object Adapter from the ORB */
/* get a reference of type Multiplier: 
   register the servant with POA and get a stub for it */
Multiplier multiplier = MultiplierHelper.narrow(rootPOA.servant_to_reference(servant));
/* construct the MultiplierProvider servant passing the stub to it */
MultiplierProviderImpl provider = new MultiplierProviderImpl(multiplier);
/* then register provider in Naming Context, so it can be obtained by the client using the name */