public void doSomething(boolean b1, boolean b2){
    int state = (b1 ? 1 : 0) + (b2 ? 2 : 0);
    while(true){
        switch (state){
            case 1: doThis(); break;
            case 3: doThis();
            case 2: doThat();
            default:
        }
    }
}