import org.junit.Test

@Test
public void addNewItem(){
    hardwarestore.addNewItem("123RT", "sink", "kitchen", 34, 4.51f);
    assertNotNull("Test Failed Message", hardwarestore.getItem(0));

}