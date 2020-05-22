ArrayList<LeaderBoard> output = new ArrayList<LeaderBoard>();
for (LeaderBoard i : input) {
    boolean shouldAdd = true;
    for (LeaderBoard o : output) {
        if (i.gameName.equals(o.gameName)
            && i.gamerTag.equals(o.gamerTag)
            && i.platform.equals(o.platform)) {
            o.win += i.win;
            o.lose += i.lose;
            shouldAdd = false;
            break;
        }
    }
    if (shouldAdd) {
        output.add(i);
    }
}
return output;