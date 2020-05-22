package com.example.editlistinvaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.List;

@Theme ( "mytheme" )
@SuppressWarnings ( "serial" )
public class MyVaadinUI extends UI
{
    List<Person> personList = null;
    BeanContainer<String , Person> personBeanContainer = null;
    Table personTable = null;
    Button editPersonButton = null;
    VerticalLayout layout = null;

    @WebServlet ( value = "/*" , asyncSupported = true )
    @VaadinServletConfiguration ( productionMode = false , ui = MyVaadinUI.class , widgetset = "com.example.editlistinvaadin.AppWidgetSet" )
    public static class Servlet extends VaadinServlet
    {
    }

    @Override
    protected void init ( VaadinRequest request )
    {
        this.layout = new VerticalLayout();
        layout.setMargin( true );
        layout.setSpacing( true );

        this.personList = new ArrayList<>();
        this.personList.add( new Person( "Susan" ) );
        this.personList.add( new Person( "Ingrid" ) );
        this.personList.add( new Person( "Pierre" ) );
        this.personList.add( new Person( "François" ) );

        this.personBeanContainer = new BeanContainer<>( Person.class );
        this.personBeanContainer.setBeanIdProperty( Person.PROPERTY.UUID );    // Use the name property as the item ID of the bean
        this.personBeanContainer.addAll( this.personList ); // Feed the beans to the container.
        this.personTable = new Table( "Person" , personBeanContainer ); // Present the bean container in a table.
        this.personTable.setSelectable( true );
        //this.personTable.setPageLength( this.personBeanContainer.size() );
        layout.addComponent( this.personTable );

        this.editPersonButton = new Button( "Edit" );
        this.editPersonButton.addClickListener( ( Button.ClickEvent event ) -> {
            editPerson();
        } );
        layout.addComponent( this.editPersonButton );

        this.setContent( layout );
    }

    private void editPerson ()
    {
        // Fetch the data to be displayed in detail.
        Object itemId = this.personTable.getValue();  // Get id of item currently selected by user.
        Item item = this.personBeanContainer.getItem( itemId );
        Window window = new PersonDetailWindow( itemId , item , this.personBeanContainer , this.personTable );
        window.setModal( true );
        window.center();
        window.addCloseListener( ( Window.CloseEvent e ) -> {
            // Dump original data.
            System.out.println( "Original data [-----" );
            for ( Person p : this.personList ) {
                System.out.println( "person bean: " + p.toString() ); // Notice the new 'modified' value is lost.
            }
            System.out.println( "----]" );
        } );
        this.addWindow( window );
    }

}