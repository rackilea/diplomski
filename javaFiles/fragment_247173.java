public enum State {
    MENU {
        public AState createInstance() { return new Menu();}
    },
    PLAY {
        public AState createInstance() { return new Play();}
    };

    public abstract AState createInstance();
}