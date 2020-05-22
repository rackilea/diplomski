Checkbox[] checkboxes = ... // For instance { ONE, TWO, ... } 
int index = 0;

for (int i = 0; i < checkboxes.length; ++i) {
    index <<= 1;
    if (checkboxes[i].isChecked()) {
       index |= 1;
    }
}