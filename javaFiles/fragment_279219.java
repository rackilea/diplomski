public interface Door {
    /**
     * Checks if the door is open.
     * @return {@code true} if the door is open, {@code false} if not.
    boolean isOpen();

    /**
     * Attempt to open the door.
     * @return {@code true} if the door was successfully opened, 
     * {@code false} if not.
     * In other words, if a call to {@code open} returns {@code true}, a
     * subsequent call to {@link #isOpen} will return {@code true}.
     */
    boolean open();

    /**
     * Attempt to close the door.
     * @return {@code true} if the door was successfully closed, 
     * {@code false} if not.
     * In other words, if a call to {@code close} returns {@code true}, a
     * subsequent call to {@link #isOpen} will return {@code false}.
     */
    void close();
}

public class RegularDoor implements Door {
    private boolean isOpen;

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean open() {
        return isOpen = true;
    }

    @Override
    public boolean close() {
        return isOpen = false;
    }
}


public class LockedDoor implements Door {
    private Lock lock;
    private boolean isOpen;

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean open() {
        if (!lock.isLocked()) {
            return isOpen = true;
        }
        return false;
    }

    @Override
    public boolean close() {
        return isOpen = false;
    }

    // Not shown here - methods to lock and unlock the door
}