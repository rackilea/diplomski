@Override
    public Timestamp convertToDatabaseColumn(Long aLong) {
        if (aLong == null)
            return null;
        return new Timestamp(aLong);
    }