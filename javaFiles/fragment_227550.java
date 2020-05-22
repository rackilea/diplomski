class Main{

    public static void main(String[] args) {

        List<Player> friendsList = new ArrayList<Player>();
        friendsList.add(new Player(1));
        friendsList.add(new Player(2));
        friendsList.add(new Player(3));

        List<Stats> stats = new ArrayList<Stats>();
        stats.add(new Stats(1,100));
        stats.add(new Stats(2, 300));
        stats.add(new Stats(3,200));

        Collections.sort(stats, 
                (Stats s1, Stats s2)->s1.getScore().compareTo(s2.getScore())
                );

        List<Player> highscore = new ArrayList<Player>();
        for(Stats s : stats){
            for(int i = 0; i < stats.size(); i++){
                if(friendsList.get(i).id == s.getUserId()){
                    highscore.add(friendsList.get(i));
                }
            }
        }

        Collections.reverse(highscore);

        for(Player p : highscore){
            System.out.println(p.getId());
        }

    }
}