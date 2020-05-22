public S get(T key)   
{
    if(fromto.containsKey(key)) return fromto.get(key);
    return null;
}


public T get(S key)   
{
    if(tofrom.containsKey(key)) return tofrom.get(key);
    return null;
}