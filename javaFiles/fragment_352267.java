...
final ArrayList list = new ArrayList<>();
list.add("Richard Felmon age 23");
list.add("Nestor Mersy age 44");
list.add("Bruto Char age 12");
list.add("Filemon Mandela age 33");
list.add("Sukyuu Nirasu age 39");
myList.setAdapter(new ArrayAdapter<String>(this, R.layout.layout_list, list));