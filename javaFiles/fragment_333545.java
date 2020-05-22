public String convertIntToBase(int i, int base){
    final StringBuilder builder = new StringBuilder();
    do {
        builder.append(i % base);
        i /= base;
    } while(i > 0);
    return builder.reverse().toString();
}