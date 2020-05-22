for ( int i = 0; i < numberChar.length; i++ )
    {
        /*** If input matches a number char, method returns true ***/

        if ( input == numberChar[ i ] )
           isNumber = true;
    }

    return isNumber;
}