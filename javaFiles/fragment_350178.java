++++++++++ > + ; N i j 
< ; point to N 
[
    > ; move pointer to i
    [ >> + > + <<< - ] ; add i to t1 and t2
    > ; move to j
    [ < + > - ] ; add j i 
    >> ; move to t2
    [ << + >> - ] ; add t2 to j 
    < ; move to t1
    [ >> + << - ] ; add t1 to t3
    >> ; move to t3 
    [ < + < + >> - ] ; move t3 to t1 and t2
    <<<<< -
]
>>> .