String[] leftStrings = mapping1.get(KEY_NAME).split("/");
String[] rightStrings = mapping2.get(KEY_NAME).split("/");

int comp = 0;
for (int i = leftStrings.length - 1; i >=0; i--) {
  comp = leftStrings[i].compareTo(rightStrings[i]);
  if (comp != 0) {
    break;
  } 
}

return comp;