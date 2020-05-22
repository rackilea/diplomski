TextField textField1, textField2;
Button btn;
static int fac;
public static int faculteit(int n) {
    int temp = 1;//this is a temporal variable that we use to compute the output of this method
    for (int i = 1; i <= n; i++) 
    {
        temp*= i;
    }
    return temp;
}