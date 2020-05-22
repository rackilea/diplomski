void keyPressed() {

    Random rand = new Random();

    if (key == 'l'){
        // Obtain a number between [0 - 5].
        p1diceroll = rand.nextInt(6) + 1;

        // [...]

        pos_l = (pos_l + p1diceroll) % fields.size();
    }

    if (key == 'a'){

        // Obtain a number between [0 - 5].
        p2diceroll = rand.nextInt(6) + 1;

        // [...]        

        pos_a = (pos_a + p2diceroll) % fields.size();
    }
}