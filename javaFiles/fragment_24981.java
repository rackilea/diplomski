while (true) {
    //Waits forever for the next available event. Pauses here until something is available.
             EventSet eventSet = eventQ.remove();
             for(Event event: eventSet){
                       if(event instanceof ClassPrepareEvent){
                            ClassPrepareEvent classPrepareEvent = (ClassPrepareEvent)event;
                            ReferenceType refType = classPrepareEvent.referenceType();
                            System.out.println("---"+refType.name() + " loaded.");
                        }
               vm.resume()
             }
}