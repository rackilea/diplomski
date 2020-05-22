public class FirstRobot() extends Thread {
    // Place for 10 objects
    private Object[] data = new Object[10];

    public boolean isDataEmpty() {
        // Check all entries for "null"
        for (Object entry : data) {
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    // Other thread stuff
}

public class SecondRobot extends Thread {
    private FirstRobot firstRobot;

    public SecondRobot(FirstRobot firstRobot) {
        // Second robot needs to access the "length" of the data
        this.firstRobot = firstRobot
    }

    @Override
    public void run() {
        // Wait for data to not be empty
        while (firstRobot.isDataEmpty()) {
            // Wait and try again afterwards
            Thread.sleep(100);
        }

        // Data is now not "empty"
    }
}