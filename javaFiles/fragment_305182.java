@Override
public void paint(Graphics g) {
    while (running) {
        for (Perspective p : perspectives) {
            System.out.println(p.getPerspective());
            while (!switchPerspective) {
                System.out.println("Rendering");
                p.start(g);
                sleep(100);
            }
            switchPerspective = false;
        }
        sleep(10);
    }
}