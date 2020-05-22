public int countDuplicates()
  {
      int duplicates = 0;
      for (int i = 0; i < list.size(); i++) {
          for (int j = i+1; j < list.size(); j++) {
              if (list.get(i).equals(list.get(j))) duplicates++;
          }
      }

      return duplicates;
  }