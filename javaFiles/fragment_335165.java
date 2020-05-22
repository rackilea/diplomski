AlertDialog.Builder builder = new AlertDialog.Builder(this);
View view = layoutInflater.inflate(R.layout.meme_post_actions_dialog,null);
        builder.setView(view);
builder.setView(layout);
alertDialog = builder.create();
alertDialog.show();
alertDialog.getWindow().setLayout(600, 400); //<--Controlling width and height.