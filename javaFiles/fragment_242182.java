lst = getSomeItems().stream().map(i->{  //Collection<X>
      X tmp=new X();
      tmp.setField1(i.getField1());  //copy some fields
      tmp.setField2(i.getField2());
      tmp.setField3(i.getField3());
      return tmp; })
    .distinct()
    .collect(toList());