Date[] dl1={sf1.parse("2016-07-22"), sf1.parse("2016-07-20"), sf1.parse("2016-07-18"), sf1.parse("2016-07-18"), sf1.parse("2016-07-18"), sf1.parse("2016-07-20"), sf1.parse("2016-07-18")};
    Date[] dl2={sf2.parse("22.07.2016"), sf2.parse("20.07.2016"), sf2.parse("18.07.2016"), sf2.parse("18.07.2016"), sf2.parse("18.07.2016"), sf2.parse("20.07.2016"), sf2.parse("18.07.2016")};

    List<Date> l1= Arrays.asList(dl1);
    List<Date> l2= Arrays.asList(dl2);



    for(int i=0;i<l1.size();i++){
        if(l1.get(i).compareTo(l2.get(i))==0){
            System.out.println("Date matched");
        }else{
            System.out.println("Date did not matched");
        }
    }