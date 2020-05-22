package test;

public class PageControllerImpl implements PageController {

    @Override
    public void setMainApp(PageController c) {
        // TODO your implemenrtation

    }

    public static void main(String[] args) {
        PageController testController = new PageControllerImpl();
        testController.setMainApp(testController);        
    }

}