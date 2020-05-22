public void save() {
    // Do something to the object before continuing
    mRTEDao.create(getThis());
}

public void delete() {
    // Do something to the object before continuing
    mRTEDao.delete(getThis());
}