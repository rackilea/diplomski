keyDao.getAllkeys().observe(this, new Observer<List<Key>>() {
    @Override
    public void onChanged(@Nullable List<Key> keysFromDB) {
        allKeys = keysFromDB;
    }
});