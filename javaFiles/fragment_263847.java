private Chunk returnCorrectColor(char letter) {
    if (letter == 'b'){
        return B;
    }
    else if(letter == 'g'){
        return G;
    }
    return new Chunk(String.valueOf(letter), RED_NORMAL);
}