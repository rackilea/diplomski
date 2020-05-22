try{
while(true){
    try{
        stack.pop();
    catch(StackElement e){
        processElement(e);
    }
}
catch(EmptyStackException ese){
    // probably not much to do here. 
}