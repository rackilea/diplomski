EntityTransaction tran = manager.getTransaction();
tran.begin();

try {
    Person savedPerson1 = manager.merge(new Person("Carl", "Gauss"));
    Person savedPerson2 = manager.merge(new Person("Benoit", "Mandelbrot"));
    tran.commit();
} catch (Exception e) {
    tran.rollback();
}

manager.close();
factory.close();