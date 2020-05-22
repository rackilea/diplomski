@Test
    public void testExecute() throws Exception
    {
        ActionProxy proxy = getActionProxy("/secure/profile_process.action");
        ProfileAction profileProxy = (ProfileAction) proxy.getAction();
        profileProxy.setAppointmentDateCode("09/27/2011:D:8AM-12PM");

        String result = proxy.execute();
        assertEquals(result, "success");
    }