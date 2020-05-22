@Override
public void run() {
    SharedResource resource = new SharedResource();
    resource.access(Thread.currentThread().getName());

}