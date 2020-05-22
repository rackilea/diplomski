sendEmail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.button5){
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ emailAddress });
                i.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                i.putExtra(android.content.Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(i, "Send email"));
            }

        }
    });