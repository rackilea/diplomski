Query<Test> q = db.createQuery(Test.class);
q.or(
  q.criteria("endTime").lessThan(now), 
  q.criteria("arrayField").doesNotExist()),
  new WhereCriteria("'this.arrayField.length && this.arrayField[this.arrayField.length-1].time < " + now +"'")
);