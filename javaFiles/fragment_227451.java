package com.robotium.solo;

import java.lang.reflect.Field;

public class SoloHack {

  private final Solo mSolo;

  public SoloHack(Solo solo) {
    mSolo = solo;
  }

  public void hack() throws NoSuchFieldException, IllegalAccessException {
    Field field = mSolo.waiter.getClass().getDeclaredField("sleeper");
    field.setAccessible(true);

    // Object value = field.get(mSolo.waiter);
    // Class<?> aClass = value.getClass();

    field.set(mSolo.waiter, new SleeperHack());

    // Object newValue = field.get(mSolo.waiter);
    // Class<?> newClass = newValue.getClass();
  }
}