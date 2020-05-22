public void setCounter(int i) {
    int oldValue = counter;
    int newValue = i;
    pcs.firePropertyChange(CHANGED, oldValue, newValue);
    counter = newValue;
    System.out.println("setCounter finished with oldValue=" + oldValue + ", newValue=" + newValue);
}