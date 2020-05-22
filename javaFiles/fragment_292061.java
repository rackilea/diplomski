void setVar(string x){
    myPrivateVar = x;

    //log the change..
    writeToLog("myPrivateVar was updated to: " + x + " at <blah blah>");

    //inform others of the change.
    updateDependantConfiguration();
}