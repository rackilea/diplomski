public void onClick(View v) {
        if (v.getId() == R.id.block4)
          if (txtNumber.hasFocus()) {
             txtMessage.requestFocus();
        } else {
            txtNumber.requestFocus();
        }
}