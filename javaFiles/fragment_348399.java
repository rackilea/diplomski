/*remember to first clear the callback of the drawable you are replacing to prevent memory leaks...
* Get the Drawables for the button by calling: myButton.getCompoundDrawables(), then loop through that calling myOldDrawable.setCallback(null);
* e.g:*/

for(Drawable myOldDrawable : myButton.getCompoundDrawables())
{
   myOldDrawable.setCallback(null);
}

//use null where you don't want a drawable
myButton.setCompoundDrawablesWithIntrinsicBounds(null,null,null, myNewDrawable);