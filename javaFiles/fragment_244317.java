final DateDialog d = new DateDialog();
 d.show(getChildFragmentManager(), "DateDialog");
 getChildFragmentManager().executePendingTransactions();
 d.setDismissListener(new DismissListener() {
     @Override
     public void onDismiss(boolean hasDate) {
         if (hasDate) {
             DoStuff();
         }
     }
 });