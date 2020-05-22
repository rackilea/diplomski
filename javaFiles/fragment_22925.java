pointcut navigation(AutoHandling handling) : execution(* navigation(..)) 
                                             && @annotation(handling);

// Collect whatever other context you need
pointcut processAutoHandleCall() : execution(* *.processAutoHandling());

pointcut wormhole(AutoHandling handling) : processAutoHandleCall() 
                                           && cflow(navigation(handling));

after(AutoHandling handling) : wormhole(hanlding) {
   ... you advice code
   ... access the slot using handling.slot()
}