public Application(final Context context)
{
    super(context);

    getMetadataService().addExtension("html", MediaType.TEXT_HTML, true);
}