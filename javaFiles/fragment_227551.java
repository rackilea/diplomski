class Player{
    Integer id;
    Player(Integer id){
        this.id = id;
    }
    Integer getId(){
        return id;
    }
}

class Stats{
    Integer userId;
    Integer score;
    Stats(Integer userId, Integer score){
        this.userId = userId;
        this.score = score;
    }
    Integer getScore(){
        return score;
    }
    Integer getUserId(){
        return userId;
    }
}