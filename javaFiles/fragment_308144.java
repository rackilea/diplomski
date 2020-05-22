public class Model {
    private static Model instance = new Model();

    public static Model getInstance() {
        return instance;
    }

    public Receipts[] getAllReceipts() {
        return allreceipts;
    }

    public void setAllReceipts(Receipts[] allreceipts) {
        this.allreceipts = allreceipts;
    }

    public static class Receipts {
        private Bitmap image;
        private String currentDate = "";
    }

    private Receipts[] allReceipts;
}