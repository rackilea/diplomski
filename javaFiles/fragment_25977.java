int countNumberOfOnes(int n) { 
    int count = 0; 
    while (n > 0) { 
        n &= (n - 1); 
        count++; 
    } 
    return count; 
}