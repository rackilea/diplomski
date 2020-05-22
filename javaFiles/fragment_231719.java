listener= new OnFocusChangeListener() {    
        LinearLayout layout_nama_pp=(LinearLayout)findViewById(R.id.layout_nama_pp);
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
                layout_nama_pp.setBackgroundResource(R.drawable.border_corner_baris1);
            }else {
                layout_nama_pp.setBackgroundResource(R.drawable.border_corner_baris1_klik);
            }
        }
    };
gelar_pp.setOnFocusChangeListener(listener);
ibu_pp.setOnFocusChangeListener(listener);
edit_bukti_lain_pp.setOnFocusChangeListener(listener);