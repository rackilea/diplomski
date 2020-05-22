Button button=new Button(context);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params1.addRule(BELOW,card.getId());
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
           // params2.addRule(BELOW,card.getId());
            params2.addRule(ALIGN_PARENT_RIGHT,button.getId());

            addView(imageview, 0, params);

            button.setText("left");
            button.setGravity(Gravity.START);
            addView(button, 1, params1);
            Button button1=new Button(context);
            button1.setText("right");
            //button.setGravity(Gravity.END);
            addView(button1, 2,params2);