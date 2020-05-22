boolean isRescanRequired = true;
while(isRescanRequired){
    // your scanning code goes here
    if (packets >= min && packets <= max) {
        // your processing and sleep code
        isRescanRequired = false;
    }
}