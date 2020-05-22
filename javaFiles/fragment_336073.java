ClassRemapper adapter = new ClassRemapper(classWriter, new Remapper()
{
    @Override
    public String map(String internalName)
    {
        return getNewName(internalName);
    }
});