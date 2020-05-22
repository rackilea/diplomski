int k = 3;
while(k > 0)
{
    if (k % 2 == 0) {
        k --;      // <--- add
        continue; 
    }

    // k--;          <--- remove
    println(k);

    k --;         // <--- add
}