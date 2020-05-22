@Override
public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.btn_font_style) {

        font.showDialog();
    } 
    else if (id == R.id.btn_font_size) {
        // No break
        fsize.show();
    } else {  // old default case
        // Something here
    }
}