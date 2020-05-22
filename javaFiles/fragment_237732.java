public class App extends Application
{

    private final List<Country> countries = Arrays.<Country>asList(
            new Country( "Country 1" ),
            new Country( "Country 2" ),
            new Country( "Country 3" ),
            new Country( "Country 4" ),
            new Country( "Country 5" ) );


    @Override
    public void start( Stage stage )
    {
        TreeItem<Object> rootNode = new TreeItem<>( new Country( "Dummy Country that will not be shown" ) );
        rootNode.setExpanded( true );

        for ( Country country : countries )
        {
            TreeItem<Object> item = new TreeItem<>( country );
            item.getChildren().add( new TreeItem<>( new City( country.getName() + " - City 1" ) ) );
            item.getChildren().add( new TreeItem<>( new City( country.getName() + " - City 2" ) ) );
            rootNode.getChildren().add( item );
        }

        TreeView<Object> treeView = new TreeView<>( rootNode );
        treeView.setEditable( false );
        treeView.setShowRoot( false );
        treeView.setCellFactory( new Callback<TreeView<Object>, TreeCell<Object>>()
        {
            @Override
            public TreeCell<Object> call( TreeView<Object> p )
            {
                return new MyTreeCell();
            }
        } );

        final Scene scene = new Scene( new VBox( treeView ), 400, 300 );
        stage.setScene( scene );
        stage.show();
    }


    private final class MyTreeCell extends TreeCell<Object>
    {

        private final ContextMenu addMenu = new ContextMenu();
        private final MenuItem addMenuItem = new MenuItem();


        public MyTreeCell()
        {
            addMenu.getItems().add( addMenuItem );
        }


        @Override
        public void updateItem( Object item, boolean empty )
        {
            super.updateItem( item, empty );

            if ( empty )
            {
                setText( null );
            }
            else
            {
                setText( getDisplayText( item ) );
                addMenuItem.setText( getContextMenuText( item ) );
                setContextMenu( addMenu );
            }
            setGraphic( null );
        }
    }


    private String getDisplayText( Object item )
    {
        if ( item instanceof Country )
        {
            return (( Country ) item).getName();
        }
        else if ( item instanceof City )
        {
            return (( City ) item).getCode();
        }
        else
        {
            return null;
        }
    }


    private String getContextMenuText( Object item )
    {
        if ( item instanceof Country )
        {
            return "This is a Country";
        }
        else if ( item instanceof City )
        {
            return "This is a City";
        }
        else
        {
            return null;
        }
    }


    public static class Country
    {

        private final SimpleStringProperty name;


        private Country( String name )
        {
            this.name = new SimpleStringProperty( name );
        }


        public String getName()
        {
            return name.get();
        }


        public void setName( String fName )
        {
            name.set( fName );
        }
    }


    public static class City
    {

        private final SimpleStringProperty code;


        private City( String code )
        {
            this.code = new SimpleStringProperty( code );
        }


        public String getCode()
        {
            return code.get();
        }


        public void setCode( String newcode )
        {
            code.set( newcode );
        }
    }


    public static void main( String[] args )
    {
        launch( args );
    }

}