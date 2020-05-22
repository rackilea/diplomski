public String toString(){
    return String.format("(%.1f%+.1fi)%n", real, imaginary);
}

public String toString( boolean fubar ){
    return String.format("z=%.3f(cos(%.3f)+isin(%.3f))%n",real,imaginary,imaginary);
}