// We get the View of the Activity
View content = (View) activity.findViewById(android.R.id.content).getParent();

// And its parent
ViewGroup parent = (ViewGroup)  content.getParent();

// The container for the menu Fragment is a FrameLayout
// We set an id so we can perform FragmentTransactions later on
FrameLayout menuContainer = new FrameLayout(this.activity);
menuContainer.setId(R.id.flMenuContainer);

// The visibility is set to GONE because the menu is initially hidden
menuContainer.setVisibility(View.GONE);

// The container for the menu Fragment is added to the parent
parent.addView(menuContainer);