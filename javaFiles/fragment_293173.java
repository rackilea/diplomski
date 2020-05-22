package work.basil.example;

import java.util.EnumSet;
import java.util.Set;

public enum Color {
    BLACK( "Black" ),                       // Pass arguments to each declared constant instant name, as you are really calling the constructor on each `static` `final` class constant object being automatically instantiated.
    GREY( "Grey" ),
    RED( "Red" ),
    GREEN( "Green" ),
    BLUE( "Blue" );

    private String displayName;             // Store the display name as a member variable on each enum instance.

    // Constructor     
    Color ( String displayName ) {          // Define a constructor taking the display name argument you passed above.
        this.displayName = displayName;
    }

    String getDisplayName ( ) {
        return this.displayName;
    }

    public static void main ( String[] args ) {
        System.out.println( "Color.BLACK.toString(): " + Color.BLACK.toString() );
        System.out.println( "Color.BLACK.getDisplayName(): " + Color.BLACK.getDisplayName() );

        Set < Color > monochromeColors = EnumSet.of( Color.BLACK , Color.GREY );
        boolean isRedMonochrome = monochromeColors.contains( Color.RED ); // ➙ false.
        System.out.println( "isRedMonochrome: " + isRedMonochrome );
    }
}