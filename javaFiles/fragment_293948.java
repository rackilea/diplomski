public static void main(String[] args) {
            GameMaster master = GameMaster.instance();
            MainWindow window = new MainWindow();
            GameBoard gameBoard = null;
            if(args.length > 0) {
                    if(args[0].equals("test")) {
                            master.setTestMode(true);
                    }
                    try {
                            Class c = Class.forName(args[1]); // <-- this is l. 39
                            gameBoard = (GameBoard)c.newInstance();
                    }