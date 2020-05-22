public class DataChangedTask extends TimerTask {

    @Override
    public void run() {
        // Code checks if there is a data change and refreshes the table data.
        // This also refreshes the table column with check box -
        // as checked or un-checked depending on the true/false value
        // in the boolean property in DataClass.
    }
}