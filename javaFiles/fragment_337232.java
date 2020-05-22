public class IndexInterpreter {

    //Using a switch here to illustrate, you can make your own mapping logic.
    public static int getIndex(char letter) {
        switch(letter) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            //the swtich goes on and on...         
        }
    }
}