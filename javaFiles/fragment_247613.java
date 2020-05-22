package test;

import java.util.concurrent.atomic.AtomicBoolean;

public class SmartCardApi {
    private AtomicBoolean inSlot = new AtomicBoolean(false);

    public boolean isCardInSlot() {
        return inSlot.get();
    }

    public void insert(int slot) {
        System.out.println("Inserted into " + slot);
        inSlot.set(true);
    }

    public void eject() {
        System.out.println("Ejected card.");
        inSlot.set(false);
    }
}