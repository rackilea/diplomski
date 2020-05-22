// Create ViewGroup as container for both lists
LayoutParams rootParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
LinearLayout root = new LinearLayout(this);
root.setLayoutParams(rootParams);

// Create LayoutParams for the lists - both identical in this example
LinearLayout.LayoutParams listParams = new LinearLayout.LayoutParams(0, LayoutParams.FILL_PARENT);
listParams.weight = 1;
ListView leftList = new ListView(this);
ListView rightList = new ListView(this);
leftList.setLayoutParams(listParams);
rightList.setLayoutParams(listParams);

// Add lists to container
root.addView(leftList);
root.addView(rightList);

// Set container as content view
setContentView(contentView);