int sign1 = (p1 >= 0) ? 1 : -1;
int sign2 = (p2 >= 0) ? 1 : -1;

int result = Integer.compare(sign2, sign1);

if( result == 0){
    // same sign
    result = sign1 * Integer.compare(p1, p2);
}
return result;