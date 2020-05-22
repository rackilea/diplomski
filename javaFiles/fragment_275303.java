public int test() throws Exception {
    int i = new Random().nextInt();
    if (i > 0) { 
        throw new Exception("exception");
    }
    else {
        return 0;
    }
}