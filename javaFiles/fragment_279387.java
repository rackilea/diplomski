public void addObserver(Observer<T> observer){
    this.observers.add(observer);
}

public void removeObserver(Observer<T> observer) {
    this.observers.remove(observer);
}