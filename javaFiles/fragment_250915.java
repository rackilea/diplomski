public class MyHystrixCommand extends HystrixCommand<Object> { ... }

MyHystrixCommand command = new MyHystrixCommand();

command.execute();

if(command.isResponseTimedOut()){
    //do post processing
}