private long time = 0;

@Test
public void test() {
    AbstractDelayService service = new AbstractDelayService(new Sleeper(){
        void sleep(long ms) {
            time+=ms;
        }, delayFunction, failureCouner){};
    Assert.assertEquals(time, 0);
    service.delay();
    Assert.assertEquals(time, 1000);
}