super.onInitializeAccessibilityNodeInfo(host, info);

ArrayList<View> childrenViews = new ArrayList<>();
host.addChildrenForAccessibility(childrenViews);

StringBuilder text = new StringBuilder();
for (View view : childrenViews) {
  if (view instanceof TextView) {
    text.append(((TextView)view).getText());
  }                              
}

text.append(" is awesome");
info.setContentDescription(text.toString());