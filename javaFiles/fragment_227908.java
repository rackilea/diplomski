char[] array = text.toCharArray();
int j = 0;
for (int i = 0; i <array.length; i++) {
   if (Character.isLowerCase(array[i])) {
       array[j++] = Character.toUpperCase(array[i]);
   } else if (Character.isUpperCase(array[i])) {
       array[j++] = Character.toLowerCase(array[i]);
   } else if (Character.isSpace(array[i])) {
       array[j++] = array[i];
   }
}
return new String(array, 0, j);