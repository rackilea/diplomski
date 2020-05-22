public String markingAvg(Marking id) {
    System.out.println("id = " + id);
    Query m = em.createQuery("SELECT (m.markSectionOne + m.markSectionTwo + m.markSectionThree + m.markSectionFour + m.markSectionFive + m.markSectionSix + m.markSectionSeven + m.markSectionEight + m.markSectionNine + m.markSectionTen + m.markSectionEleven + m.markSectionTwelve + m.markSectionThirteen) FROM MARKING m WHERE m.id = :id", Double.class);
    m.setParameter("id", id.getId()); // Note the getId()

    Object avg = m.getSingleResult();
    return null; // Do you really want to be returning null here?
}