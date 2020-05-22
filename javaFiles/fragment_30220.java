public class YourClassName extends Activity { // The name of your class would obviously be here; and I assume it's an Activity
    public void addObjectLabel(final String name) { // This is where we declare "name" to be final
        mLayout.post(new Runnable() {
            public void run() {
                TextView label;
                label = new TextView(YourClassName.this); // This is the name of your class above
                label.setText(name);
                label.setWidth(label.getWidth()+100);
                label.setTextSize(20);
                label.setGravity(Gravity.BOTTOM);
                label.setBackgroundColor(Color.BLACK);
                panel.addView(label);
            }
        });
    }
}