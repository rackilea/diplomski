ArrayList<LeaderBoard> output = new ArrayList<LeaderBoard>();
:outer
for (LeaderBoard i : input) {
    for (LeaderBoard o : output) {
        if (i.gameName.equals(o.gameName)
            && i.gamerTag.equals(o.gamerTag)
            && i.platform.equals(o.platform)) {
            o.win += i.win;
            o.lose += i.lose;
            break outer;
        }
    }
    output.add(i);
}
return output;