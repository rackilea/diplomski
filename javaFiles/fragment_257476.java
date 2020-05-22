@SuppressWarnings("unchecked")
    private Class<? extends Serializable> getClassOfArrayOfSerializableNoArrayInitialization
        (final Class<? extends Serializable> subtypeClass) throws ClassNotFoundException
    {
        return (Class<Serializable>) Class.forName("[L" + subtypeClass.getName() + ";");
    }