class GameObject {

    private int id;
    private static int count = 0;
    private boolean shouldDelete = false;
    private Object monitor = new Object();//will be used to lock critical section

    public GameObject() {
        id = ++count;
    }


    public void update(Thread thread) {
        synchronized (monitor) {
            shouldDelete = Math.random() < 0.5;//just a simple randomization
            System.out.println(thread.getName() + " updates GameObject. should be removed =" + shouldBeRemoved());
        }
    }

    public boolean shouldBeRemoved() {
        synchronized (monitor) {
            return shouldDelete;
        }
    }

    public void render(Thread thread) {
        System.out.println(thread.getName() + " renders GameObject " + id);
    }
}