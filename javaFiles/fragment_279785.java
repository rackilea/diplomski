Vacancy vacancy1 = new Vacancy();
vacancy1.setTitle("Dumm");
Vacancy vacancy2 = new Vacancy();
vacancy2.setTitle("Dummmmm");

vacancyDao.getDatastore().save(vacancy1);

vacancy2.setId(vacancy1.getId());
vacancyDao.getDatastore().save(vacancy2);//This line will update the "Dumm" to "Dummmmm"