package second;

import workers.Employable;

public class WorkersClass {
    protected class Worker implements Employable {


        public Worker() {
            // TODO Auto-generated constructor stub
        }

        @Override
        public void work() {
            System.out.println("Hello, I'm a worker!");
        }
    }
}