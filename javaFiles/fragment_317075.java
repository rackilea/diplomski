import java.io.IOException;


    public class TestExecution {

        public boolean myProcessState = false;

        class MyProcess implements Runnable {

            public void run() {
                //------
                Process process;
                try {
                    process = Runtime.getRuntime().exec("your command");
                    process.waitFor();
                    int processExitValue = process.exitValue();

                    if(processExitValue == 0) {
                        myProcessState = true;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        public void doMyWork() {

            MyProcess myProcess = new MyProcess();

            Thread myProcessExecuter = new Thread(myProcess);
            myProcessExecuter.start();

            while(!myProcessState) {
                // do your job until the process exits with success
            }
        }

        public static void main(String[] args) {

            TestExecution testExecution = new TestExecution();
            testExecution.doMyWork();
        }
    }