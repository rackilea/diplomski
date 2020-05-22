else if (list.get(i).contains("h"))
{
  list.remove(i);
  i--;
}
else if (list.get(i).contains("o"))
{
  list.add(i+1, list.get(i));
  i++;
}