public class CustomResourceArrayPropertyEditor extends ResourceArrayPropertyEditor
{
  private final ResourcePatternResolver resourcePatternResolver;

  public CustomResourceArrayPropertyEditor()
  {
    this(new PathMatchingResourcePatternResolver());
  }

  public CustomResourceArrayPropertyEditor(ResourcePatternResolver resourcePatternResolver)
  {
    super(resourcePatternResolver, null);
    this.resourcePatternResolver = resourcePatternResolver; 
  }

  @Override
  public void setAsText(String text)
  {
    String pattern = resolvePath(text).trim();
    String[] resourceNames = StringUtils.commaDelimitedListToStringArray(pattern);
    List<Resource> resourceList = new ArrayList<Resource>();
    try {
      for (String resourceName: resourceNames)
      {
        Resource[] resources = resourcePatternResolver.getResources(resourceName);
        for (Resource res: resources)
          resourceList.add(res);
      }
    }
    catch (IOException ex) {
      throw new IllegalArgumentException("Could not resolve resource location pattern [" + pattern + "]", ex);
    }

    setValue(resourceList.toArray(new Resource[0]));
  }
}