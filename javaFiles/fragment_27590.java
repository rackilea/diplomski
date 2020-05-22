public void testInjection() {
    String orderBy = "this_.type desc, type";

    Criteria crit = this.getSession().createCriteria(DemoEntity.class);
    crit.addOrder(Order.asc(orderBy));      
    crit.list();
}