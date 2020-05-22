private int round = 0;

@Override
public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    round++;

    //...
    pw1 = new PrintWriter(new File("temp1-" + round + ".txt"));
    //...
}