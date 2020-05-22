>> M = java.util.HashMap;
>> M.put(1,'a');
>> M.put(2,33);
>> s = struct('a',37,'b',4,'c','bingo')

s = 

    a: 37
    b: 4
    c: 'bingo'

>> M.put(3,struct2hashmap(s));
>> M

M =

{3.0={a=37.0, c=bingo, b=4.0}, 1.0=a, 2.0=33.0}

>>