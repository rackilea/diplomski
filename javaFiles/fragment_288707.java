public class MyClassTest {
    private MyClass myClass;
    private Random mockedRandom;

    @Before
    public void setup() {
        myClass = spy(new MyClass());
        mockedRandom = mock(Random.class);
        when(myClass.createRandom()).thenReturn(mockedRandom);
    }

    @Test
    public void getRandNumShouldGenerateAValidIndexForCHAR_LIST() {
        //Given CHAR_LIST.size() = 5
        when(mockedRandom.nextInt(5)).thenReturn(2);

        final int randomNumber = myClass.getRandNum();

        assertEquals(2, randomNumber);
        verify(mockedRandom).nextInt(5);
   }

   //a "black box" approach:
   @Test
   public void blackboxish() {
      //Make sure CHAR_LIST.size() = 3
      when(myClass.createRandom()).thenReturn(new Random());
      for (int i = 0; i < 100; i++) {
          final int random = myClass.getRandNum();
          assertTrue(random >= 0);
          assertTrue(random < 3);
      }
   } //there is a theoritical possibility of a false positive here, but it's small..