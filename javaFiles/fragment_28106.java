ReviewTemplate template = course.getReviewTemplate(); //assuming the variable course
Review review = new Review();
review.setCourse(course);
review.setRuleOne(template.getRuleOne());
// Copy other properties here

EntityManager em = // get the entity manager here
em.persist(review);

// Assume a set or list of customers
for (Customer customer : customers) {
    CustomerReview cr = new CustomerReview();
    cr.setReview(review);
    cr.setCustomer(customer); 
    cr.setFeedbackScore(template.getDefaultFeedbackScore());
    // set other CustomerReview properties here

    em.persist(cr);

    // You can create CustomerReviewLine here as well