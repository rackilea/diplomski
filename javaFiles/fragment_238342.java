package work.basil.example.ui;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route ( "" )
final public class AuthenticateView extends HorizontalLayout
{
    // Constructor
    public AuthenticateView ( )
    {
        super ();

        // Widgets
        this.add ( new LoginForm () );

        // Arrange
        this.getStyle ().set ( "border" , "6px dotted DarkOrange" );  // DEBUG - Visually display the  bounds of this layout.
        this.setSizeFull ();
        this.setJustifyContentMode ( FlexComponent.JustifyContentMode.CENTER ); // Put content in the middle horizontally.
        this.setDefaultVerticalComponentAlignment ( FlexComponent.Alignment.CENTER ); // Put content in the middle vertically.

    }
}