int tmp1 = --var1;       // tmp1 = 9, var1 = 9
int tmp2 = ++var1;       // tmp2 = 10, var1 = 10
int tmp3 = tmp1 + tmp2;  // tmp3 = 19
int tmp4 = var1++;       // tmp4 = 10, var1 = 11
int tmp5 = tmp3 + tmp4;  // tmp5 = 29

int b = tmp5;            // b = 29