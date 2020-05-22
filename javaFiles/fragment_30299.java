int create(){
    int random = (int)(1+Math.random()*15);
    return random;
}

...

int getAnswer(){
    answer = create();
    answer2 = create();
    return answer*answer2;
}