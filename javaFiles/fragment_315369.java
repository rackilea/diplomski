@Test(expected = IllegalArgumentException.class) 
public void add_with_index_greater_than_size() {
    l0.add(42, 10);  // index > size 
}  

@Test(expected = IllegalArgumentException.class) 
public void add_with_index_less_than_zero() {
    l0.add(42, -1);  
}  

@Test(expected = IllegalArgumentException.class) 
public void add_with_null_arg() {
    l0.add(null, 10); 
}  

@Test
public void add() {
    l0.add(42, 10);  
    Assert.assertEquals(42, l0.get(10));
}