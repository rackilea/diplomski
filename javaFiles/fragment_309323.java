Layout_rod_1.removeAllViews();
Iterator iterator = rod1_stack.iterator();
while (iterator.hasNext()) {
    TextView tv = iterator.next();
    Layout_rod_1.addView(tv);
}