static Test panel = new Test(500, 500, 1); // one which displays the values of the members

public static void main(String args[]) throws InterruptedException {
    Thread time = new Thread(new Test()); // and another which updates the variables

    frame.add(panel);
    Frame.showFrame(frame);

    time.start();

}