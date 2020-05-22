db.add("1.1","10.10");
    db.add("6.6","6.6");
    db.add("7.7","7.7");
    db.add(new DataModel("8.8","8.8"));


    db2.add("1.1","1.1");
    db2.add("2.2","2.2");
    DataModelCampaigns dmc = new DataModelCampaigns("3.3","3.3");
    db2.add(dmc);
    db2.add("4.4","4.4");
    db2.add(new DataModelCampaigns("1.1","10.1"));