new Verifications() {{
    Collection<Dog> dogCollection;

    mDogDao.saveAllDog(dogCollection = withCapture());

    assertEquals(5, dogCollection.size());
}};