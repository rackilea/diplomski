// Button:
        Button ButtonNumber = (Button) itemView.findViewById(R.id.item_Button);
        ButtonNumber.setTag(currentPost.getButtonid()); 
        ButtonNumber.setText(Html.fromHtml(currentPost.getButton()));
        ButtonNumber.setOnClickListener(new OnClick());

        Log.e("ButtonNumber.setId", "Found:" + ButtonNumber.getTag());