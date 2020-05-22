if (key < (int) tab.get(tab.size() / 2)) {
      return bSearch(smallerThanKey, key);
  } else {
      return bSearch(largerThanKey, key);
  }
}