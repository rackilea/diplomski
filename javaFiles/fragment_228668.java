public double totalPerAccount(Account account) {
        Double total = em.createNamedQuery("Booking.totalPerAccount", Double.class)
                .setParameter("ACCOUNT", account)
                .getSingleResult();

    if(total == null)
        return 0.0;
    else
        return total;
    }