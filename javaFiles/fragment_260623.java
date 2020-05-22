public class MyGame extends ApplicationAdapter {
    //......

    PlatformResolver platformResolver;

    public MyGame (PlatformResolver platformResolver){
        this.platformResolver = platformResolver;
    }

    //.....
    public void render(){
        //...

        if (shouldHandleTasks) platformResolver.handleTasks();

        //...
}