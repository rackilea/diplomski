public class TestA_IT extends BaseIT {
    @Test
    public void myTest {
        //do some specific stuff and verify with resulting params

        doVerify(params..);
    }

    protected boolean isValid(Object o) {
        return (o instanceOf YourObject) ? ((YourObject)o).isValid() : false;
    }   
}