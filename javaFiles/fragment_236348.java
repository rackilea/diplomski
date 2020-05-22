prev.add(1);    // prev = [1]
    res.add(prev);  // res = [[1]] // all good so far
    if(numRows==1)
        return res;

    prev.add(1);    // prev = [1, 1]            
    res.add(prev);  //  res = [[1, 1], [1, 1]]  or [prev, prev] // here's the problem
    if( numRows==2)
        return res;