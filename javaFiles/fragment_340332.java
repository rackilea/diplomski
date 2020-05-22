ConcurrentHashMap<ActivityIdentifier ,Object> locks = new...
public Object getLock(ActivityIdentifier actID){
    Object res = locks.get(actID); //avoid unnecessary allocations of Object

    if(res==null) {
        Object newLock = new Object();
        res = locks.puIfAbsent(actID,newLock );
        return res!=null?res:newLock;
    } else return res;
}