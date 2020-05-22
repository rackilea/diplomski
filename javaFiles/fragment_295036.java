String keyword = search.next().toLowerCase();
  System.out.println("searching for: " + keyword);

  boolean found = false;
  for (String element : list) {
    if (element.contains(keyword)) {
      found = true;
    }
  }

  if (found) {
    System.out.println("found");
  }
  else {
    System.out.println(" not found");
  }
}