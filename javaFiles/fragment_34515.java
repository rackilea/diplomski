int score = 0;
ArrayList<Integer> tied = new ArrayList<>();
for (int i = 0; i < golf.length; i++) {
    if(golf[i][hole] > score){ // new winnger
        score = golf[i][hole]; // adjust high score
        tied.clear(); // throw out every tied player
        tied.add(winner); // add the winner
    } else if (golf[i][hole] == score){ // we have a new tied player
        tied.add(i); // add him
    }
}