package com.robotium.solo;

public class SleeperHack extends Sleeper {

  @Override
  public void sleep() {
    sleep(50);
  }
}