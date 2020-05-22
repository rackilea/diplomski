public class Joshua{

    public final String complete = "start" + "finish";


    public void check(String argument) {


        switch(argument)
        {
         case complete: //This compiles properly
        }

        switch(argument)
        {
         case name(): //This doesn't compile
        }
    }

    public final String name(){

        return complete;
    }

}