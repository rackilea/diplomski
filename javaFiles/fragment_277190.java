final FrameLayout frameLayout = (FrameLayout)findViewById(R.id.fragment_container);

FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
//left, top, right, bottom
params.setMargins(10, 10, 10, 10);
frameLayout.setLayoutParams(params);