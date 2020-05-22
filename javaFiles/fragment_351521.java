Session session = HibernateSession.openSession();
session.beginTransaction();

CarDescription carDescription = ConvertDTO.convertCarDescription(carDescriptionDto);

Car car = new Car();
carDescription.setCar(car);

session.save(car);
session.save(carDescription);