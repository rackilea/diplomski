interface TestInterface<T extends Enum<T>>
{
  public abstract void test(T command);
}

class TestImpl implements TestInterface<PerspectiveCommands>
{
  @Override
  public void test(PerspectiveCommands command) {
    if(command == PerspectiveCommands.PERSPECTIVE){
        //do something
    }
  }
}