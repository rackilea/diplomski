this.addCheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(map.this);
                LayoutInflater layoutInflater = d.getLayoutInflater();
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.cheer_dialog);// custom layout for the dialog

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(d.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                d.show();
                d.getWindow().setAttributes(lp);

                LinearLayout layout = d.findViewById(R.id.dialog_layout_root);
                final EditText title = d.findViewById(R.id.cheerDialogText);

                ImageButton addCheerOk = (ImageButton) d.findViewById(R.id.addCheerOk);

                Button b = new Button(d.getContext());
                b.setText("yo");

                layout.addView(b, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
}