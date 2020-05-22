public List<Weapon> getDbWeapons()
{
    List<Weapon> dbWeapons = new ArrayList<>();
    EntityTransaction entr=em.getTransaction();
        entr.begin();
    TypedQuery<Weapon> query = em.createQuery("SELECT i FROM Weapon i", Weapon.class);
    dbWeapons = query.getResultList();
    em.getTransaction().commit();

    return dbWeapons;
}