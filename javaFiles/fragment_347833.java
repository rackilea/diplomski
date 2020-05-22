public int Tx(int n) {
    if(n == 0)
        return 10;
    else
        return Tx(n+1); // n will never reach 0!
}