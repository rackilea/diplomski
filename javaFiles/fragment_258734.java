public void saveCar() {
    carDao.deleteAll();

    CarDocument carDocument1 = new CarDocument();
    carDocument1.setId(1L);
    carDocument1.setName("audi");
    carDocument1.setMadeInCountry("germany");

    carDao.save(carDocument1);
}