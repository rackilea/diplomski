private Dialog getInstanceMyDialog() {
  final Dialog bookMarkDialog= new Dialog(this,R.style.BookmarkDialogNoTitle);
  bookMarkDialog.setContentView(R.layout.bookmark_dialog);

  Button addButton = (Button)bookMarkDialog.findViewById(R.id.dialogAddButton);
  addButton.setOnClickListener(new OnClick .........)
  ......... same for cancel.

  return bookMarkDialog;
}