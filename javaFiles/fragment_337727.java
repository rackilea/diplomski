protected void onPostExecute(List<MIC_OrderDetails> lst) {
    dialog.setMessage("Inflating Data...");
    if (lst.get(lst.size() - 1).getResult().contains(("success"))) {
        list.clear();
        list.addAll(lst);
        adapter.notifyDataSetChanged();
        dialog.dismiss();
    } else {
        dialog.dismiss();
        toastText.setText("Problem in loading Items");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 410);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();
    }
}