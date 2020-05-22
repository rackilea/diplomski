class A {
    public void execute() {

        /* some code where threading is not required*/

        new Thread() {
            public void run() {
                /* block of code which need to execute via thread */
            }
        }.start();
    }
}