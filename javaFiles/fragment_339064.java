@Test
public void TestGenerateId()
{
   RandomNumberGenerator mockRNG = createMock(RandomNumberGenerator.class);
   expect(mockRNG.getRandomNumber()).andReturn(0.123);
   replay(mockRNG);

   VGenerator vgenerator = new VGenerator(mockRNG);
   long id = vgenerator.generateID();
   Assert.Equals(5,id); // e.g. given random number .123, result should be 5

   verify(mockRNG);
}