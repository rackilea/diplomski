@Test
public void boardBus_usingInstanceSpecificMockingForNewedInstances()
{
    new Expectations() {
        @Capturing @Injectable Bus bus;

        {
            bus.board(); result = "mocked";
        }
    };

    String result = new Car("myCar").boardBus();
    assertEquals("mocked", result);
}

@Test
public void boardBus_usingPartialMocking()
{
    final Bus bus = new Bus("");
    new Expectations(bus) {{ bus.board(); result = "mocked"; }};

    String result = new Car("myCar").boardBus();
    assertEquals("mocked", result);
}