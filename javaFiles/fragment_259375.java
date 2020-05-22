static Test panel = new Test(500, 500, 1);

public static void main(String args[]) throws InterruptedException {
    Thread time = new Thread(panel);

    frame.add(panel);
    Frame.showFrame(frame);

    time.start();

}