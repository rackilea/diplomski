char [] letters = {' ', 'a', ' ', 'b', ' ', 'c'};

for(int i = 0; i < letters.length; i++) {
    int random = (int) (Math.random()* letters.length);

    if (letters[random] == ' ' || letters[i] == ' ') continue; // here

    char temp = letters[i];
    letters [i] = letters [random];
    letters [random] = temp;
}