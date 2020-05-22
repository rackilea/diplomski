//finds the greatest common factor, used in simplifying
public int greatestCommonFactor(int num, int den)
{
    if(den == 0){
        return num;
    }
    return greatestCommonFactor(den, num % den);
}