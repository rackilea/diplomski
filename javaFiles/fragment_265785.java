int score = null;
for (PlayerList pl: myArrayList) {
    if(pl.getName() == teamName)
        score = pl.getScore();
}
System.out.println(score == null ? "No score available.": score);