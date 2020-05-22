double high = d, low = 0, epsilon = 0.000001;
while (low + epsilon < high)
{
    double mid = (low + high)/2;
    int gapsOnLeft = (int)(s/mid); // gaps = points - 1
    if (gapsOnLeft + 1 > n)
        gapsOnLeft = n - 1;
    int gapsOnRight = n - gapsOnLeft - 2; // will be -1 when there's no point on the right
    double leftOffset = mid*gapsOnLeft;
    // can be > d with no point on the right, which makes the below check work correctly
    double rightOffset = d - mid*gapsOnRight;
    if (leftOffset + mid <= rightOffset && rightOffset >= e)
        low = mid;
    else
        high = mid;
}
System.out.println(low);