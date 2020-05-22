@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 80) {
        if(resultCode == Activity.RESULT_OK){
            View dialog = LayoutInflater.from(this).inflate(R.layout.dialog_fmcg_popup, null);
        TextView tvfmcg2 = dialog.findViewById(R.id.tv_fmcg2);
        tvfmcg2.setText(message);
        swipeDismissDialog = new SwipeDismissDialog.Builder(this)
            .setView(dialog)
            .setOnSwipeDismissListener(new OnSwipeDismissListener()
            {
                @Override
                public void onSwipeDismiss(View view, SwipeDismissDirection direction)
                {
                    Preferences.setString(Prefkey.last_qualified_fmcg_voucher_on_remove, message);
                }
            })
            .setFlingVelocity(0)
            .setOverlayColor(0)
            .build()
            .show();
        }
    }
}