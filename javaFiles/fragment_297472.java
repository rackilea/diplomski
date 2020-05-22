ImageView iv = tbb.getTopBarButton(ButtonEnum.IMG_1);

LinearLayout iViewLayout = new LinearLayout(this);
iViewLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
iViewLayout.setOrientation(LinearLayout.HORIZONTAL);

iViewLayout.addView(iv);

ll.addView(iViewLayout);