short s = 191;
short first = (short) (s & 0x000F);
short second = (short) ((s >> 4) & 0x000F);
short third = (short) ((s >> 8) & 0x000F);
short fourth = (short) ((s >> 12) & 0x000F);

call_the_method_to_convert_each();

s = fourth;
s = ((short) ((s << 4) | third));
s = ((short) ((s << 4) | second));
s = ((short) ((s << 4) | first));