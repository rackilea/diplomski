Spec row1 = GridLayout.spec(0);
Spec row2 = GridLayout.spec(1);
Spec row3 = GridLayout.spec(2);
Spec row4 = GridLayout.spec(3);

Spec col0 = GridLayout.spec(0);
Spec col1 = GridLayout.spec(1); 
Spec col2 = GridLayout.spec(2);

GridLayout gridLayout = new GridLayout(this);
GridLayout.LayoutParams first = new GridLayout.LayoutParams(row1, col0);
/*Here you can set options for first cell which is in first row and first column.*/
first.width = screenWidth;
first.height = quarterScreenWidth * 2;
twoByTwo1.setLayoutParams(first);
twoByTwo1.setGravity(Gravity.CENTER);
twoByTwo1.setBackgroundColor(Color.RED);
twoByTwo1.setText("TOP");
twoByTwo1.setTextAppearance(this, android.R.style.TextAppearance_Large);
gridLayout.addView(twoByTwo1, first)
//You can set all cells like above.