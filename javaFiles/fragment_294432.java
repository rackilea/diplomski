public void main(String[] args) throws Exception {
    IntPermutationsGenerator g = new IntPermutationsGenerator(3);
    while (g.hasNext()){
        System.out.println(Arrays.toString(g.next()));
    }

    //gives
    //[0, 1, 2]
    //[0, 2, 1]
    //[1, 0, 2]
    //[1, 2, 0]
    //[2, 0, 1]
    //[2, 1, 0]
}