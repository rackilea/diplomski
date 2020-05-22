final class Animation {

    final Thread animator;

    public Animation()
    {
      animator = new Thread(new Runnable() {
        // logic to make animation happen
       });

    }

    public void startAnimation()
    {
      animator.start();
    }

    public void awaitCompletion() throws InterruptedException
    {
      animator.join();
    }
}