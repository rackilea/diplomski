class Main extends JavaPlugin {

    private final MySQL mysql;

    public Main(MySQL mysql)
    {
        this.mysql = mysql
    }

    //Class which is called first 
    void onEnable() {

        //Just an example of initializing
        mysql.init();
        mysql.open();
    }
}

class MySQL {

    private final Main main = new Main(this);

    void init(){}
    void open(){}
}