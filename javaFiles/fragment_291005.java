import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class StackOverFlow26116823 {

    private static String password = "s";
    private static String getPassword(){
        return password + "a";
    }

    @Test
    public void testFail() {
        for(int i = 0 ; i < 100; i ++){
            assertEquals("a" , getPassword());
        }
    }


    @Test
    public void testLoopToSave() {
        List<AssertionError> errorS = new ArrayList<AssertionError>();
        for(int i = 0 ; i < 100; i ++){
            try{
                assertEquals("a" , getPassword());
            }catch(AssertionError e){
                errorS.add(e);
            }
        }
        assertTrue( getAllErrorMessageTrace(errorS) , errorS.size() == 0 );
    }

    private String getAllErrorMessageTrace(List<AssertionError> errorS) {
        // TODO Auto-generated method stub
        return "";
    }

    @Test
    public void testLoopJustCountAndLogging() {
        boolean errorFlag = false;
        for(int i = 0 ; i < 100; i ++){
            try{
                assertEquals("a" , getPassword());
            }catch(AssertionError e){
                System.out.println( i + ": " + e.getMessage() );
                errorFlag = true;
            }
        }
        assertTrue( "Some errors that you can find in log. ", errorFlag);   
    }
}