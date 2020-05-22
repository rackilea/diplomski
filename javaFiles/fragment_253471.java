Session session = sessionFactory.openSession();
session.beginTransaction();
Donor donor = new Donor();
Blood blood = new Blood();
blood.setDonor(donor);
HashSet<Blood> bloods = new HashSet<Blood>();
bloods.add(blood);
donor.setBlood(bloods);
//set some another fields if you want or they are NOT NULL in database
session.save(donor); //blood should be saved automatically due to cascade
session.getTransaction().commit();
session.close();