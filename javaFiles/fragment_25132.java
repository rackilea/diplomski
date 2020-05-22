StringBuffer text = new StringBuffer();

for (Node<T> child : children) {
  text.append('/');
  text.append(child.toString());
}
return text.toString;