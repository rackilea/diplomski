// creating seession factory object
SessionFactory factory = cfg.buildSessionFactory();
// creating session object
Session session = factory.openSession();
// creating transaction object
Transaction t = session.beginTransaction();

User u1 = new User();
u1.setUserName("Jo");

User u2 = new User();
u2.setUserName("Nick");

Preference p = new Preference();
p.setPrefName("mapping");

UserPreferences up1 = new UserPreferences();
up1.setPreference(p);
up1.setUser(u1);
up1.setPrefValue("ManyToMany");
session.save(up1);

UserPreferences up2 = new UserPreferences();
up2.setPreference(p);
up2.setUser(u2);
up2.setPrefValue("OneToMany");
session.save(up2);

t.commit();// transaction is committed
session.close();

session = factory.openSession();

// creating transaction object
t = session.beginTransaction();

Long u1id = u1.getId();
Long u2id = u2.getId();
System.out.println(u1id + ", " + u2id);
User user = (User) session.get(User.class, u1id);
System.out.println(user.getUserName() + ", " + user.getUserPrefs());
user = (User) session.get(User.class, u2id);
System.out.println(user.getUserName() + ", " + user.getUserPrefs());

t.commit();// transaction is committed
session.close();