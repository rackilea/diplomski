myViewPager.addOnPageChangeListener(new SimpleOnPageChangeListener() {
   void onPageSelected(int position) {
      boolean shouldIShowAlert = // implement this
      if (shouldIShowAlert) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activityAdapter);
                alertDialog.setTitle(R.string.title);
                alertDialog.setMessage(R.string.subtitle);
                alertDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                AlertDialog alertDialogBuilder1 = alertDialog.create();
                alertDialog.show();
      }
   }
});