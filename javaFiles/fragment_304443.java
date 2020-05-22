public static void main(String[] args) {
  LinkedList<Integer> list1 = Lists.newLinkedList(
      Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30));
  LinkedList<Integer> list2 = Lists.newLinkedList(
      Arrays.asList(5, 10, 15, 20, 25, 30));

  LinkedList<Integer> combined = combine(list1, list2);
  System.out.println(combined);
}

private static LinkedList<Integer> combine(LinkedList<Integer> list1,
    LinkedList<Integer> list2) {
  LinkedList<Integer> combined = new LinkedList<>();
  combine(list1, list2, combined);
  return combined;
}

private static void combine(LinkedList<Integer> list1,
    LinkedList<Integer> list2, LinkedList<Integer> combined) {
  if (list1.size() > 0 && list2.size() > 0) {
    if (list1.peek() == list2.peek()) {
      list1.remove();
    } else if (list1.peek() < list2.peek()) {
      combined.add(list1.remove());
    } else {
      combined.add(list2.remove());
    }
  } else if (list1.size() > 0 && list2.size() == 0) {
      combined.add(list1.remove());
  } else if (list1.size() == 0 && list2.size() > 0) {
    combined.add(list2.remove());
  } else {
    return;
  }
  combine(list1, list2, combined);
}