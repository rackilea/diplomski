public class ProductAdapter extends SomeAdapter {

    private Activity create;

    public  ProductAdapter(Activity activity, List<Product> productList) {
        create = activity;
        this.productList = productList;
    }

    private void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(create);
        // ...
        alertDialogBuilder.create().show();
    }

}