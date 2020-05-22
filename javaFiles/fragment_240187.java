public void notifyObserver(IAction sender) {
    for (int i = 0; i < observers.size(); i++) {            
        IActionObserver observer = (IActionObserver) observers.get(i);  
        if (observer != sender)  
            observer.update();
    }
}