int min = 1;
int max = 10;
String values[] = new String[(max-min+1)];
for(int i = 0;(i+min) <= max;i++) {
    values[i]= Integer.toString((max-i));
}

NumberPicker picker = (NumberPicker) findViewById(R.id.picker);
picker.setMaxValue(max-min);
picker.setMinValue(0);
picker.setWrapSelectorWheel(false);
picker.setDisplayedValues(values);