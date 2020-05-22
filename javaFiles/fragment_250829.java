@Bean
@Scope("prototype")
@Value("\\path\\to\\the\\input\\file")
public InputFile inputFile (String path)
{
    InputFile inputFile = new InputFile();
    inputFile.setPath(path);
    return inputFile;
}