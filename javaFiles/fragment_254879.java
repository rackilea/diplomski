// First set up a subquery to get the ids of Persons who are available
     // (assuming that the Person must be available for the entire duration)
     DetachedCriteria dc = DetachedCriteria.forClass(Person.class)
         .setProjections(Projections.id())
         .createAlias("availability", "a")
         .add(Restrictions.le("a.to", endDate)
         .add(Restrictions.ge("a.from", startDate);

     Criteria crit = session.createCriteria(Person.class)
          .createAlias("competence", "c")
          .add(Restrictions.eq("c.name", competenceName)
          .add(Subqueries.in(dc,"id");

     List<Person> people = crit.list();