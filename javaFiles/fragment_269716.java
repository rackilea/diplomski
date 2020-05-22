package com.basilbourque;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.time.Instant;

/**
 * Testing retrieval of contents from a TextArea.
 * <p>
 * See: https://stackoverflow.com/q/48447476/642706
 * <p>
 * By Basil Bourque.
 */
@Theme ( "mytheme" )
public class MyUI extends UI
{
    static final long serialVersionUID = 42L;

    @Override
    protected void init ( VaadinRequest vaadinRequest )
    {
        // Init layout.
        final VerticalLayout layout = new VerticalLayout();
        layout.setHeight( 100 , Unit.PERCENTAGE );

        // Widgets
        TextArea textArea = new TextArea( "TextArea" );
        textArea.setWidth( 100F , Unit.PERCENTAGE );
        textArea.setHeight( 100F , Unit.PERCENTAGE );
        String mode = textArea.getValueChangeMode().toString();  // `ValueChangeMode` enum. https://vaadin.com/download/release/8.3/8.3.0/docs/api/com/vaadin/shared/ui/ValueChangeMode.html
        textArea.setValue( "ValueChangeMode: " + mode );

        Button processButton = new Button( "Process" );
        processButton.addClickListener( clickEvent ->
        {
            String x = ":contentFile=" + Instant.now() + "\n" + textArea.getValue();
            textArea.setValue( x );
            textArea.setCursorPosition( 0 ); // Move insertion-point to top of the field for easy data-entry.
        } );

        // Arrange layout.
        layout.addComponents( textArea , processButton );
        setContent( layout );
    }

    @WebServlet ( urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true )
    @VaadinServletConfiguration ( ui = MyUI.class, productionMode = false )
    public static class MyUIServlet extends VaadinServlet
    {
        static final long serialVersionUID = 42L;
    }
}