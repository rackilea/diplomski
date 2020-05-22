public static int addValues(ArrayList<? extends Alpha> arr, Gamma gam) 
{
    int sum = 0;
    for (Alpha alpha : arr) {
        try {
            sum += alpha.value(gam);
        } catch (ValueException e) {
        }
    }
    return sum;
}