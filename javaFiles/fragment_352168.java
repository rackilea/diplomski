buffer1.Lock();

try {

    while( !buffer1.BufferNotFull ) {

          buffer1.WaitOnConditionVariable();
    }

    buffer1.AddElement(...);

} finally {

    buffer1.Unlock();
}