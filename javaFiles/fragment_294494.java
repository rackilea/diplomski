//Concrete Command
public class LightOnCommand implementsCommand
{
//reference to the light
Light light;

public LightOnCommand(Light light)
{
    this.light = light;
}

public void execute()
{
    light.switchOn();
}

}


 //Concrete Command
public class LightOffCommand implementsCommand
{
//reference to the light
Light light;

public LightOffCommand(Light light)
{
    this.light = light;
}

public void execute()
{
    light.switchOff();
}

}