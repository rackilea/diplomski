//either this:
private Random random = new Random();
//or this:
Random createRandom() {
    return new Random();
}

private int getRandNum() {
    //either this:
    return random.nextInt(CHAR_LIST.size());
    //or this:
    return createRandom().nextInt(CHAR_LIST.size());
}