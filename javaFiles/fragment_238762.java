if(v==btn_clear)
 {
      dismiss();
      SignatureFragment dialog = new SignatureFragment(saveListner);
      dialog.show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");
 }