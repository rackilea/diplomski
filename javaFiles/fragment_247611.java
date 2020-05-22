public void addPipe() {
    for (int i = 0; i < pipe.length; i++) {
        if (pipe[i] == null) {
            pipe[i] = new Pipe(this.width, (int) Math.random() * (this.height - 200));
            System.out.println("Pipe Added.");
            numPipes += 1;
        }
    }
    repaint();
}