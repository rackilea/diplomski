public void onClick()
{
    final File file = (File)getModelObject();
            ...
    IResourceStream resourceStream = new FileResourceStream(
            new org.apache.wicket.util.file.File(file));
    getRequestCycle().setRequestTarget(.../* uses resourceStream */...);
}