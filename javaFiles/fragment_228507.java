.
.
.
item.setTag(currentItem );
item.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {

            Item it = (Item) v.getTag();
        }
    });
.
.
.