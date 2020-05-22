class A {
    private String id;
    private List<B> bs = new ArrayList<B>();
    private ReentrantReadWriteLock lk = new ReentrantReadWriteLock();

    A(String id){
        this.id = id;
    }

    public List<B> getBs(){
        lk.readLock().lock(); // acquire the read lock, since this operation does not affect A contents
        return bs;
        lk.readLock().unlock();
    }

    public void setBs(List<B> bs){
        lk.writeLock().lock(); // acquire the write lock, which automatically avoids further reading/writing operations
        this.bs=bs;
        for( B elem : bs )
        {
            // internal B elements need a reference to the reading part of the lock
            elem.setLock(lk.readLock()); 
        }
        lk.writeLock().unlock();
    }

    public void addBs(List<B> bs){
        [...] // similar approach that in setBs
    }

    public void addB(B b){
        [...] // similar approach that in setBs
    }

    public void deleteB( B elem ) // Or whatever notation you want
    {            
        lk.writeLock().lock(); // acquire the write lock
        B internalElem = bs.get(bs.indexOf(elem));             
        if( internalElem != null )
        {
            bs.remove(internalElem);
            bs.unsetLock();
        }
        lk.writeLock().unlock();
    }
}

class B {
    private String id;
    private List<String> tags;
    private Lock lk;

    B(String id){
        this.id = id;
        lk = null;
    }

    public void setLock(Lock l){ lk = l; } // put additional controls if you want
    public void unsetLock()
    { 
        lk = null; 
    }

    private void lockInternal()
    {
        if(lk!=null){ lk.lock(); }
    }

    private void unlockInternal()
    {
        if(lk!=null){ lk.unlock(); }
    }

    public List<String> getTags(){
        List<String> ref = null;            
        lockInternal();
            [...] //internal operations
        unlockInternal();
        return ref;
    }

    public void setTags(List<String> tags){
        [...] // similar approach that in getTags
    }

    public void addTags(List<String> tags){
        [...] // similar approach that in getTags
    }

    public void addTag(String tag){
        [...] // similar approach that in getTags
    }
}