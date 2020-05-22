import java.io.IOException;  // <=== Tell the compiler we're going to use this class below
class Certainty  
{
    public static final void main(String[] args) {
        try {                      // `try` starts a block of code we'll handle (some) exceptions for
            System.out.println ("Are you sure (y - yes, n - no)?");
            int ch = System.in.read ();
            switch (ch)
            {
               case 'Y':
               case 'y': System.out.println ("I am sure.");
                        break;
               case 'N':
               case 'n': System.out.println ("I am not sure.");
                         break;
               default : System.out.println ("Incorrect choice.");
            }
        }
        catch (IOException e) {    // <== `catch` says what exceptions we'll handle
            System.out.println("An exception occurred.");
        }
    }
}