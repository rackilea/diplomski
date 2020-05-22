// assuming this is your parent layout
LinearLayout llyParent = findViewById(R.id.linearlayout);

Button[] button = new Button[10];

// then you can iterate for each child view inside the layout
int count = llyParent.getChildCount();

// count the last position of the button
int lastPosition = 0;

for (int i = 0; i < count; i++) {
   // get the child View
   View view = llyParent.getChildAt(i);

   // then check if it an instance of a Button
   if (view instanceof Button) {
      button[lastPosition] = (Button) view;

      // increment the position for the next button.
      lastPosition++;
   }

}