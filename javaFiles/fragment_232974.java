else if (tagName.equals(TAG_TIME)) {
      if (item != null) {
           item.mTime_SV = pullParser.getAttributeValue(null, "from");
            String[] parts = item.mTime_SV.split("T");
            System.out.println("Date: " + parts[0]);
            System.out.println("Time: " + parts[1]);
  }