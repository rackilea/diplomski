char[] hand = {'a','b','c','b','c'};
/* sort the hand to ensure pairs are next to each other */
for(int x=0;x<hand.length - 1;x++){
    for(int y=(x+1);y<hand.length;y++){
        if((int)hand[x] > (int)hand[y]){
            char temp = hand[y];
            hand[y] = hand[x];
            hand[x] = temp;
        }
    }
}
int score = 0;
for(int x=0;x<hand.length - 1;x++){
    if(hand[x] == hand[x + 1]){
        score++;
        /*if you want to make sure you only get pairs
          add an "x++;" that way it'll skip over the 
          letter you just tested*/
    }
}