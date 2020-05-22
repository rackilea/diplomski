public void setHandleName(String handle){ // Accept a `handle` string parameter
    if(handle.length() < 10){             // If the length of `handle` is less
                                          // than 10, enter the block
        return;                           // Leave this method immediately, without
                                          // doing anything else
    }                                     // This is the end of the conditional bit

    handleName = handle;                  // Set `handleName` to `handle`
}