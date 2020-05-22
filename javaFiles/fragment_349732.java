private void addInfo()
    {
        Bundle ext = getIntent().getExtras();
        if(ext != null)
        {
            int pos= ext.getInteger("pos");
                       //  ext.getInt("pos");

            heading.setText(headings[pos]);

            //  hey, frend, you don't have any array for selecting image-name and text
            //  image.setImageResource(images[x]);
            //  text.setText(text[x]);
        }
    }