int sum = x; // You only want to add x once, so just say the sum is equal to x
for (int i = 0; i < arr.length; i++) 
{
    // You didn´t sum the values up, you just said the sum is equal to your 
    // x value plus the element at arr[i]
    sum += arr[i];
}