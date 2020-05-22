a = <valueof 1>; //"1" is now stored in memory, and a is a index to "1" in memory.
b = a; //b now indexes a new memory location that now also stores "1".

a = <value of 2>; //"2" now replaces "1" at the indexed memory location.
output a; //You get "2" because a pass by value language will be designed to give you value, not the index.
output b; //You get "1" because when b was assigned to match a, a stored "1". But b is independent of a once assignment is complete.