class meineklasse
{
    private PrintStream out;

    meineklasse(PrintStream out) {
        this.out = out;
    }
    tuwas(String line)
    {
        out.println(line); // perfectly defined now because out is an attribute
    }

}