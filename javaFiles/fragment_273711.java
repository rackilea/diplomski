public class SeparateClassControl implements ActionListener {
    private SeparateClassView view;

    public SeparateClassControl(SeparateClassView view) {
        this.view = view;
        view.addButtonListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String text1 = view.getField1Text();
        String text2 = view.getField2Text();
        boolean result = SeparateClassModel.stringsEquivalent(text1, text2);
        view.setResult(result);
    }
}