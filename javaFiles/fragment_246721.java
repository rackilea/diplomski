i   j  count
=   =  =====
0   0  0     count++
       1     count++
    1  2     count++
    2  3     count++; continue outerLabel
1   0  4     count++; continue outerLabel
:   :  :     :
5   0  8     count++; continue outerLabel