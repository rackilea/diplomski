public ArrayList<Item> sort(List<Item> list) {

    ArrayList<Item> dateSort= new ArrayList<>();
    ArrayList<Item> result = new ArrayList<>();

    if (list!= null && list.size() != 0) {

      dateSort= new ArrayList<>(list);

      Collections.sort(
          dateSort, (o1, o2) -> Integer.compare(o1.getIntDate(), o2.getIntDate()));

      int currentDate = dateSort.get(0).getIntDate();

      ArrayList<Item> temp= new ArrayList<>();

      for (int i = 1; i < dateSort.size(); i++) {

        if (dateSort.get(i).getIntDate() > currentDate ) {
          currentDate = dateSort.get(i).getIntDate();
          result.addAll(timeSort(temp));
          temp.clear();
          temp.add(dateSort.get(i));
        }
        else{
          temp.add(dateSort.get(i));
        }

      }
    }
    return result;
  }

private ArrayList<Item> timeSort(List<Item> list) {

  ArrayList<Item> timeSort= new ArrayList<>();
  if (list!= null && list.size() != 0) {

      timeSort= new ArrayList<>(list);

      Collections.sort(
          timeSort, (o1, o2) -> Integer.compare(o1.getIntTime(), o2.getIntTime()));

  }

  return timeSort;
}