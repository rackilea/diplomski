// Have the buffer on the stack, need to
// make sure to deallocate it when you're
// done with it.
jbyte* resultBuffer = new jbyte[THE_SIZE];
fillTheBuffer(resultBuffer);
(*env)->SetByteArrayRegion(env, result, 0, THE_SIZE, resultBuffer);
delete [] resultBuffer;