//Maximum size (in pixels) of a buffered image that would be used by {@link JRViewer JRViewer} to render a report page.
//If rendering a report page would require an image larger than this threshold
//(i.e. image width x image height > maximum size), the report page will be rendered directly on the viewer component.
//If this property is zero or negative, buffered images will never be user to render a report page.
//By default, this property is set to 0.
public static final String VIEWER_RENDER_BUFFER_MAX_SIZE