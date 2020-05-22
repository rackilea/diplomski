interface Uniqueness {
    long getUUID();
    void setUUID(long uuid);
}

interface Storable {
    long getId();
    void setId(long id);
}

class UniquenessSupport implements Uniqueness {

    private long uuid;

    @Override
    public long getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(long uuid) {
        this.uuid = uuid;
    }
}

class StorableSupport implements Storable {
    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

class Some implements Uniqueness, Storable {

    private UniquenessSupport uniquenessSupport;
    private StorableSupport storableSupport;

    public Some() {
        uniquenessSupport = new UniquenessSupport();
        storableSupport = new StorableSupport();
    }

    @Override
    public long getUUID() {
        return uniquenessSupport.getUUID();
    }

    @Override
    public void setUUID(long uuid) {
        uniquenessSupport.setUUID(uuid);
    }

    @Override
    public long getId() {
        return storableSupport.getId();
    }

    @Override
    public void setId(long id) {
        storableSupport.setId(id);
    }
}