import junit.framework.TestCase;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PlayerTest  {

    @Test
    public void NameTest(){
        Player player = new Player(1);
        player.setName("Roberto");
        String name= "Roberto";
        assertEquals(name,player.getName());
    }

}