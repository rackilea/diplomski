QuickAction qa;
quickButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            qa = new QuickAction(v);

            qa.addActionItem(about);
            qa.addActionItem(email);
            qa.setAnimStyle(QuickAction.ANIM_GROW_FROM_RIGHT);

            qa.show();
        }
    });


    about.setTitle("About");
    about.setIcon(getResources().getDrawable(R.drawable.about));
    about.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(qa.isShowing())
               qa.dismiss();
            //some code
        }
    });

    email.setTitle("Email");
    email.setIcon(getResources().getDrawable(R.drawable.email));
    email.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(qa.isShowing())
               qa.dismiss();
            //some code
        }
    });