public class Checked extends Thread {

    Label checkedLabelReference;
    public Checked(Label label){
        this.checkedLabelReference = label;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            MainForm.intVerifiedNews ++;
            //Here you need to pass the intVerifiedNews value to the Label 
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    checkedLabelReference.setText(MainForm.intVerifiedNews);//update text
            }});
            System.out.println(MainForm.intVerifiedNews);
        }

    }
}