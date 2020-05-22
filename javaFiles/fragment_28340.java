public synchronized void activateInput(boolean activate) {
    this.activeInput = activate;
    System.out.println("active" + activeInput);
}

    if (activeInput) {
        writer.write(data);
        writer.flush();
        activateInput(false);
    }