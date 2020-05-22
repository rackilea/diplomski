buffer1.Lock();

try {

    if( !buffer.IsEmpty ) { 

         ... remove element ...
         BufferNotFull = true;
         NotifyConditionVariable();
    }
} finally {
    buffer1.Unlock();
}