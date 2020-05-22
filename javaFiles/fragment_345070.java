package com.example.editlistinvaadin;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class PersonDetailWindow extends Window
{
    VerticalLayout layout = null;
    FieldGroup fieldGroup = null;

    @PropertyId ( Person.PROPERTY.NAME )
    TextField nameField = null;
    @PropertyId ( Person.PROPERTY.UUID )
    TextField uuidField = null;
    @PropertyId ( Person.PROPERTY.MODIFIED )
    TextField modifiedField = null;

    Button commitButton = null;

    Object itemId = null;
    Item item = null;
    Container container = null;
    Table table = null;

    public PersonDetailWindow ( Object itemIdArg , Item itemArg , Container containerArg , Table tableArg )
    {
        this.setCaption( "Person" );
        this.layout = new VerticalLayout();
        layout.setMargin( true );
        this.setContent( layout );

        // Passing all these objects to facilitate experimentation. Perhaps only the Item is necessary.
        this.itemId = itemIdArg;
        this.item = itemArg;
        this.container = containerArg;
        this.table = tableArg;

        this.layout.setMargin( true );
        this.layout.setSpacing( true );

        this.nameField = new TextField( "Name:" );
        this.uuidField = new TextField( "UUID:" );
        this.modifiedField = new TextField( "Modified:" );

        this.uuidField.setEnabled( false );
        this.modifiedField.setEnabled( false );

        this.nameField.setWidth( 21 , Unit.EM );
        this.uuidField.setWidth( 21 , Unit.EM );
        this.modifiedField.setWidth( 21 , Unit.EM );

        this.commitButton = new Button( "Commit" );
        this.commitButton.addClickListener( ( Button.ClickEvent event ) -> {
            doCommit();
        } );

        this.layout.addComponent( this.nameField );
        this.layout.addComponent( this.uuidField );
        this.layout.addComponent( this.modifiedField );
        this.layout.addComponent( this.commitButton );

        this.fieldGroup = new FieldGroup( this.item );
        this.fieldGroup.bindMemberFields( this );
    }

    private void doCommit ()
    {
        try {
            this.fieldGroup.commit();
            // GOOD: The edited "name" value of "name" in the table row is visibly updated immediately and automatically at this point.
            // BAD: The "modified" field value was updated programmatically on the bean itself in the "setName" method, but there is no way to get that fresh value to appear in the table or the subwindow's detail form.
            // The following suggested "MethodProperty" code does not help. See: http://stackoverflow.com/q/19077760/642706 and https://vaadin.com/forum/#!/thread/408555/408554
// [
//            Property property = this.table.getContainerProperty( this.itemId , Person.PROPERTY.NAME );
//            if ( property instanceof MethodProperty ) {
//                ( ( MethodProperty ) property ).fireValueChange();
//            }
// ]

            // Dump data from bean backing this updated row in table.
            BeanItem<Person> beanItem = ( BeanItem<Person> ) this.item;
            Person person = beanItem.getBean();
            System.out.println( "Dump Person object just updated & committed: " + person );

            // Nor does this next line show fresh values in "modified" column.
// [
//            this.table.refreshRowCache();
// ]
            // We would close the window at this point, or leave window open for further editing.
            this.close();

        } catch ( FieldGroup.CommitException ex ) {
            System.out.println( "ERROR - Commit failed. CommitException: " + ex );
            Notification.show( "Commit failed." ,
                    "Your changes to this Person record are not yet saved." ,
                    Notification.Type.WARNING_MESSAGE );
        }
    }

}