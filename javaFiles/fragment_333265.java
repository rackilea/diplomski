if(msg instanceof GesturePoints) { 
    GesturePoints message = (GesturePoints) msg;
    //Result rslt = initial_Theta(message);
    //getSender().tell(rslt);
    getSender().tell(new Result());
}