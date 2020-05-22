int indexOf(String container, String text, int index) {
  //Too short container
  if (container.length() < text.length()) return -1; 
  //found
  else if (container.startsWith(text)) return index;
  //keep searching
  else return indexOf(container.substring(1), text, index+1);
}
indexOf("banana", "nana", 0) == 2;