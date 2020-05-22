public void setCounter(int i) {
    int oldValue = counter;
    int newValue = i;
    counter = newValue;
    pcs.firePropertyChange(CHANGED, oldValue, newValue);
    System.out.println("setCounter finished with oldValue=" + oldValue + ", newValue=" + newValue);
}