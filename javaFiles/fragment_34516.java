if(tied.size() <= 1){
    str += "Winner: " + winner + " with score: " + score;
} else {
    str += "Tied: ";
    for(int i : tied){ // add all tied player to the output
        str += i + " ";
    }
    str += "with score: " + score;
}