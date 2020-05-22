import static org.junit.Assert.*;

    ....

    @Test
    public void testOrdered() {
        DataObj dao = new DataObj();

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put( "code", 100 );

        List<?> values = dao.getDataObj( params, conn );

        String previous = "";
        for (final Object vCurrent : values) {
            String current = vCurrent.toString();
            assertTrue("list not ordered correctly",  /* this arg is optional */
                       current.compareTo(previous) < 0);
            previous = current;
        }
    }