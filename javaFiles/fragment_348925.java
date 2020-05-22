class Whatch_Directory implements Watchable {
    public static Watchable create_watchable(String s) {
        // Your definition goes here
    }
}

LinkedBlockingQueue<Whatch_Directory> queue = 
    new LinkedBlockingQueue<Whatch_Directory>();
queue.put(Whatch_Directory.create_watchable("dir");