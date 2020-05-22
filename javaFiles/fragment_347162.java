public void testCase1()
{
  CallMethod call = new CallMethod();
  Thread t = new Thread(call);
  t.start();
  t.join(60000); // wait one minute

  assertTrue(t.alive() || call.getEndTime() - call.getStartTime() >= 60000);

}