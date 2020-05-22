a = <valueof 1>; //"1" is now stored in memory, and a is a index to "1" in memory.
b = a; //b now indexes the same memory location as a. They both index the "1" in memory.

a = <value of 2>; //"2" now replaces "1" at the indexed memory location.
output a; //In this case would get the index value the language uses.
output b; //You'd get the same index value as a since they index the same memory location.
output <valueof a>; //Now you get "2", because however it's done in the language you have extracted the data in the memory location indexed by a.
output <valueof b>; //Same output as before as b indexes the same memory location as a.