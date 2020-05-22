List<FAQ> l = new ArrayList<FAQ>();
FAQ faq1 = initFAQ(new FAQ(), 5, 1L);
l.add(faq1);
FAQ faq2 = initFAQ(new FAQ(), 3, 2L);
l.add(faq2);
FAQ faq3 = initFAQ(new FAQ(), 11, 3L);
l.add(faq3);

EasyMock.expect(faqDao.getAllOrderedDescByRating()).andReturn(l);