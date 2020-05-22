pax> cat tst.ksh 
#!/usr/bin/ksh
echo " 1  = [$1]"
echo " 2  = [$2]"
echo " :"
echo " 9  = [$9]"
echo "10a = [$10]"
echo "11a = [$11]"
echo "10b = [${10}]"
echo "11b = [${11}]"

pax> tst.ksh a b c d e f g h i j k
 1  = [a]
 2  = [b]
 :
 9  = [i]
10a = [a0]
11a = [a1]
10b = [j]
11b = [k]