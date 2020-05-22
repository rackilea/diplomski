public class ItemJunit {
    @Test
    public void addingFourtoEightReturnsTwelve(){
        Item i= new Item(8);
        assertEquals(12, i.Add(4));
    }
    @Test
    public void addingOnetoMaxIntOverflows(){
        Item i= new Item(Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE, i.Add(1));
    }
    @Test
    public void subtractOneFromTwelveReturnsEleven(){
        Item i= new Item(12);
        assertEquals(11, i.Deduct(1));  
    }
}