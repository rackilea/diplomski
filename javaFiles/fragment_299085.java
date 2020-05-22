class FileNameFactoryBean
{
    private Date date = new Date();
    private String prefix;
    private String postfix;

    public OtherBean createBean()
    {
        String filename = prefix + date.toString() + postfix;
        return new OtherBean(filename);
    }

    // Getters and Setters
}