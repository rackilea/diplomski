public long Recursiv()
{
    if(this.getNumar() == 0)
        return 0;
    if(this.getNumar() <= 2)
        return 1;
    else
        return new Fibonacci(this.getNumar() - 2).Recursiv()
             + new Fibonacci(this.getNumar() - 1).Recursiv();
}