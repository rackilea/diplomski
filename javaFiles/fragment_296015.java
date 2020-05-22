private final MAX_SIZE = 35;

public String get_val(int idx)
{
    if(idx<strings.size())
        return strings.get(idx);
    else
        return null;
}

public void set_val(int idx, String val)
{
    if(idx<MAX_SIZE)
        strings.add(val,idx);
    else
        //throw an exception if that's how you really want to do it
}