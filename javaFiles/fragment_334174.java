static AtomicReferenceArray<Boolean> instance = 
   new AtomicReferenceArray<Boolean>(COUNT);

private void ensure(int i)
{
    if(!instance.get(i) )
    {
        synchronized(this){
        if( !instance.get(i) ){
           initialize(i);
           instance.set(i, true);
        }
    }
}