holder.myText.setText(titleArray[position]); // same as yours, just add the lines below.

// Change the item color
if (position > 39) // position starts at 0
{
    holder.myText.setBackgroundResource(R.drawable.ability_yellow_btn);
}
else
    if (position > 19) // position starts at 0
    {
        holder.myText.setBackgroundResource(R.drawable.ability_green_btn);
    }
}