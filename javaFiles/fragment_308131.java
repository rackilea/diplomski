int upperround(int num, int base) {
    int temp = num%base;
    if (temp < 0 ) 
        temp = base + temp;
    if (temp == 0) 
        return num;
    return num + base - temp;