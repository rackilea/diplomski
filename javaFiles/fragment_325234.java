List<Test> tests = help.stream().map(
    s-> {
      Test t = new Test(s,(int) Integer.valueOf("10")));
      System.out.println(t.getText());
      others.add(t)
      return t;
    }
.collect(Collectors.toList());