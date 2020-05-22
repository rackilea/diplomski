catch(NullPointerException e){
    purchasesFail.add(sku.mSku);
    System.out.println("onActivityResult consume crashed");
    runOnUiThread(new Runnable(){
        public void run(){
            alert("Store Problems!", "There were problems consuming the product, please use RESTORE button.");
        }
    });
}