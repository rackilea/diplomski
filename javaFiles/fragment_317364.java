@NamedQuery(name = "Customer.findByDob", query = "SELECT c FROM Customer c WHERE c.dob = :dob")

        @GET
        @Path("findByDob/{dob}")
        @Produces({"application/json"})
        public List<Customer> findByDob(@PathParam("dob") String dob) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-Mon-yyyy");
            Date dobDate = sdf.parse(dob); //Create a new Java Date object. 

            Query q = em.createNamedQuery("Customer.findByDob");
            q.setParameter("dob", dobDate); //The entity manager will transform the Date to query needs.
            return q.getResultList(); 
    }