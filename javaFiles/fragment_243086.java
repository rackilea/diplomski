-(char *)convertByteArray:(int)p_int
{
    char *l_byte_array = malloc(4);
    int MASK_c = 0xFF;
    for (short i = 0; i <= 3; i++) {
        l_byte_array[i] = (char) ((p_int >> (8 * i)) & MASK_c);
    }
    return l_byte_array;
}