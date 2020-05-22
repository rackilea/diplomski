@Override
public int spUpdate_ld_oauditorid(String customerid, String appointofcaid, String auditorid, String oauditorid) {
    Integer isup = (Integer) em.createNamedQuery("updateldoauditorid")
        .setParameter("customerid", customerid)
        .setParameter("appointofcaid", appointofcaid)
        .setParameter("auditorid", auditorid)
        .setParameter("oauditorid", oauditorid)
        .getSingleResult();

return isup;
}