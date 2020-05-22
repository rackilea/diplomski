class MyObservable {

    private ArrayList<MyObserver> observersList = new ArrayList<>();

    public void addObserver(MyObserver observer) {
        observersList.add(observer)
        // OR observer.addObservable(this) , but it is kinda strange one
    }

    public void onAnimeReleased() {
        // Some other logic, release Anime and etc...
        notify();
    } 

    private void notify() {
        observersList.forEach((obs) -> obs.notify());
    }
}