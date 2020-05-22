TOKEN: {
<QUOTED: 
    "\"" 
    (
         "\\" ~[]     //any escaped character
    |                 //or
        ~["\"","\\"]  //any character except quote or backslash
    )* 
    "\"" > 
}