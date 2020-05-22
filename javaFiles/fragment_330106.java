public class GameRender() { 
    private List<Sword> swords = new ArrayList<Sword>();

    public GameRender(){
        // create the swords
        for (int i = 0; i<10 ; i++ ) {
            swords.add(new Sword());
    }

    // render the swords
    public void render() {
        for (Sword sword : swords) {
            sword.createMe();
        }

    }

}