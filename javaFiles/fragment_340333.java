private final EnumMap<ActivityIdentifier ,Object> locks;

/**
  initializer ensuring all values are initialized 
*/
{
    EnumMap<ActivityIdentifier ,Object> tmp = new EnumMap<ActivityIdentifier ,Object>(ActivityIdentifier.class)
    for(ActivityIdentifier e;ActivityIdentifier.values()){
        tmp.put(e,new Object());
    }
    locks = Collections.unmodifiableMap(tmp);//read-only view ensures no modifications will happen after it is initialized making this thread-safe
}


public Object getLock(ActivityIdentifier actID){
    return locks.get(actID);
}