private class CustomClickListener implements View.OnClickListener{
     private Item mIt;
     CustomClickListener (Item it){
        this.mIt= it;
     }

     public void onClick(View v) 
        {

            // The item that was clicked it mIt
        }
}

// When you create the views
item.setOnClickListener(new CustomClickListener(currentItem));