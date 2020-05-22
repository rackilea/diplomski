void sortByDescription(List<Item> list)
{
     Collections.sort(list, new Comparator<Item>(){
          public int compare(final Item o1, final Item o2){
              return o1.description.compareTo(o2.description);
          }
     });
}

void sortByDescriptionBackwards(List<Item> list)
{
   sortByDescription(list);
   Collections.reverse(list);
}