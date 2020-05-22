package web.deployment;

import javax.servlet.ServletContext;

public class RunClassOnDeployment implements Runnable {

    ServletContext myServletContext; // in case you need the servelet context

    RunClassOnDeployment(ServletContext sc) {
           myServletContext = sc;
    }

    public void run() {
       Thread th = new Thread();
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
                th.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted! " + e);
        }
    }
}