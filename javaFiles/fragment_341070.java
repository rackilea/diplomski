public static void main(String[] args){

        Object sevenSecond= new Object();
        Object fifteenSecond= new Object();

        Message messageObject= new Message();
        messageObject.message="seconds";

        ContinousMessageThread continousMessageThreadObject= new ContinousMessageThread(messageObject);
        SevenSecondsMessageThread secondsMessageThreadObject = new SevenSecondsMessageThread(messageObject);
        FifteenSecondsMessageThread fifteenSecondsMessageThreadObject=new FifteenSecondsMessageThread(messageObject);
    }


    static class Message{
        String message;
        Object sevenLock = new Object();
        Object fifteenLock = new Object();

        void printMessage(String message) {

            try {
                for(int i=0; true; i++){
                    if (i % 7 == 0) {
                        synchronized (sevenLock) {
                            sevenLock.notify();
                            System.out.println(i + " " + message);
                            sevenLock.wait();
                        }
                    }
                    else if (i % 15 == 0) {
                        synchronized (fifteenLock) {
                            fifteenLock.notify();
                            System.out.println(i + " " + message);
                            fifteenLock.wait();
                        }
                    }
                    else {
                        System.out.println(i + " " + message);
                        System.out.flush();
                    }
                    if (i == 50) System.exit(-1);  // stops after a few iterations
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

        }

        void printMessageFifteen(String message) {
            try {
                synchronized (fifteenLock) {
                    System.out.println(message);
                    fifteenLock.notify();
                    fifteenLock.wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized void printMessageSeven(String message) {
            try {
                synchronized (sevenLock) {
                    System.out.println(message);
                    sevenLock.notify();
                    sevenLock.wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ContinousMessageThread extends Thread {

        Message messageObject;

        ContinousMessageThread(Message messageObject){
            this.messageObject=messageObject;
            new Thread(this,"seconds").start();
        }

        @Override
        public void run() {
            messageObject.printMessage(this.messageObject.message);
        }

    }


    static class FifteenSecondsMessageThread extends Thread{

        Message messageObject;

        public FifteenSecondsMessageThread(Message messageObject) {
            this.messageObject=messageObject;
            new Thread(this,"seconds").start();

        }

        @Override
        public void run() {
            while(true){
                messageObject.printMessageFifteen("Fifteen Seconds over");
            }
        }

    }

    static class SevenSecondsMessageThread extends Thread {
        Message messageObject;


        public SevenSecondsMessageThread(Message messageObject) {
            this.messageObject=messageObject;
            new Thread(this,"seconds").start();

        }

        @Override
        public void run() {
            while(true){
                messageObject.printMessageSeven("Seven Seconds over");
            }
        }

    }