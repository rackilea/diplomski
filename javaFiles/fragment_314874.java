public static char shift( char c, int shift ) {
    int l = c - 'a';
    int u = c - 'A';

    // The '>> 31' operator fills all bits with bit 31 of l
    int mask = l >> 31;

    l = ( l + shift ) % 26;
    u = ( u + shift ) % 26;

    return ( char ) ( ( ( l + 'a' ) & ~mask ) + ( ( u + 'A' ) & mask ) );
}