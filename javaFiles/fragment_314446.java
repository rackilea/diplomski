double minFscore = open.get(0).getGscore() + open.get(0).getHscore();
Node minScoreNode = open.get(0);

for(int i = 1; i < open.size(); i++) {
    Gscore = open.get(i).getGscore(); // these methods are in the Node class.
    Hscore = open.get(i).getHscore();
    Fscore = Gscore + Hscore;

    if (Fscore < minFscore) {
         minScoreNode = open.get(i);
         minFscore = Fscore;
    }
}

open.remove(minScoreNode);
closed.add(minScoreNode);