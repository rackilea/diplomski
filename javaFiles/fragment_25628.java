class MyValue implements Value {
    private Object value;
    private int type;

    public MyValue(Object value) throws RepositoryException {
        if (value == null)
            throw new RepositoryException("Value can not be null");
        this.value = value;
        if (value instanceof Boolean) {
            type = PropertyType.BOOLEAN;
        } else if (value instanceof Calendar) {
            type = PropertyType.DATE;
        } else if (value instanceof Double) {
            type = PropertyType.DOUBLE;
        } else if (value instanceof Long) {
            type = PropertyType.LONG;
        } else if (value instanceof String) {
            type = PropertyType.STRING;
        } else {
            throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
        }
    }

    @Override
    public Binary getBinary() throws RepositoryException {
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public boolean getBoolean() throws ValueFormatException,
            RepositoryException {
        if (type == PropertyType.BOOLEAN)
            return (Boolean)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public Calendar getDate() throws ValueFormatException, RepositoryException {
        if (type == PropertyType.DATE)
            return (Calendar)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public BigDecimal getDecimal() throws ValueFormatException,
            RepositoryException {
        if (type == PropertyType.DECIMAL)
            return (BigDecimal)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public double getDouble() throws ValueFormatException, RepositoryException {
        if (type == PropertyType.DOUBLE)
            return (Double)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public long getLong() throws ValueFormatException, RepositoryException {
        if (type == PropertyType.LONG)
            return (Long)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public InputStream getStream() throws RepositoryException {
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public String getString() throws ValueFormatException,
            IllegalStateException, RepositoryException {
        if (type == PropertyType.STRING)
            return (String)value;
        throw new RepositoryException("Wrong type: " + value.getClass().getSimpleName());
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return value.getClass().getSimpleName() + "(" + value + ")";
    }
}