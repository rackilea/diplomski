double number =  -0.15625;
// Code below doesn't work for 0 and NaN - just check before

long bits = Double.doubleToLongBits(number);

long sign = bits >>> 63;
long exponent = ((bits >>> 52) ^ (sign << 11)) - 1023;
long fraction = bits << 12; // bits are "reversed" but that's not a problem

long a = 1L;
long b = 1L;

for (int i = 63; i >= 12; i--) {
    a = a * 2 + ((fraction >>> i) & 1);
    b *= 2;
}

if (exponent > 0)
    a *= 1 << exponent;
else
    b *= 1 << -exponent;

if (sign == 1)
    a *= -1;

// Here you have to simplify the fraction

System.out.println(a + "/" + b);