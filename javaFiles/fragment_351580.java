@Test
public void testCube(){
    compute c  = createMock(9);
    Assert.assertTrue(27, c.cube(3));
}

public compute createMock(final int result){
    compute c = new compute(){
        @Override
        public int multiply(int a, int b){
            return result;
        }
    };
}