class MyWidgetBuilder
    implements WidgetBuilder<JComponent, SwingMetawidget> {

    public JComponent buildWidget( String elementName, Map<String, String> attributes, SwingMetawidget metawidget ) {

        if ( "my.special.type".equals( attributes.get( TYPE ) ) )

            return new JSuperWidget();
        }

        // Fall through to other WidgetBuilder

        return null;
    }