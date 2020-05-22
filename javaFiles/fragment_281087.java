first in static A->  
 i=i-- - --i;   will be 2 becoz, i-- means first assign value and then decrement the value so,i--=1111 then in satic memory i will be 1110 then --i means first decrement and then assign so, in this 1110 will become 1109 and then value of i wiil be 2.
secondly in static B->
currently i is 2.   i=--i - i--;   will be i=1-1  i will be zero
third instance block of A will be executed->
i=i++ + ++i  will be i=0+2=2
finaly instance block of B will be executed->
i=++i + i++   will be i=3+3=6