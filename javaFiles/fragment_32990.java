public string handleInput(InputKey key)
{
      String state = determineState(key);
      SomeType someResult = executeActionForState(state);
}

public String determineState(string key)
{

    String state = "";
     switch (key) {
    case S:
    case DOWN:
        state = "cycleDown";
        break;
    case W:
    case UP:
        state = "cycleUp";
        break;
    case SPACE:
    case ENTER:
        state = "select";
        break;
    default:
        break;
}

return state;
}

public void executeActionForState(string state)
{
     if ( state == "cycleup" ) {
     }

     etc etc
}