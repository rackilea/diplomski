public class SceneController {

    private Parent view1 ;
    private Parent view2 ;
    // etc... You could perhaps store these in a map, or other data structure if needed

    public Parent getView1() {
        if (view1 == null) {
            view1 = createView1();
        }
        return view1 ;
    }

    public Parent getView2() {
        if (view2 == null) {
            view2 = createView2();
        }
        return view2 ;
    }

    private Parent createView1() {
        // Build first view. (Could be done by loading FXML, etc.)
    }

    private Parent createView2() {
        // Build second view...
    }
}