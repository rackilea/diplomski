boolean hasRepeatedElements(list v) 
    if v.length <= 1 return false;
    List less, greater;
    x = v[0];
    for each y in v, except v[0]
        if y == x
            return true;
        else if y < x
            less.add(y);
        else if y > x
            greater.add(y);
    end;
    return hasRepeatedElements(less) || hasRepeatedElements(greater);
end;