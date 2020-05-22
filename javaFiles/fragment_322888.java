public class FormTest{
    private Form form;

    @Before 
    public void setup(){
        // any other needed setup
        form = getForm();
        // any other needed setup
    }

    protected Form getForm(){
        return new Form();
    }

    @Test
    // do tests of Form class
}

public class GreenTest{
    private GreenForm form;

    @Before 
    public void setup(){
        form = getForm();
        // any other needed setup
        super.setup();
        // any other needed setup
    }

    @Override
    protected Form getForm(){
        return new GreenForm();
    }

    @Test
    // do tests of how GreenForm is different from Form
    // you might also need to override specific tests if behavior of the method
    // under test is different
}