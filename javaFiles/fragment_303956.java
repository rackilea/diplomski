phrase = phrase.trim();

  /*** Counts through the length of phrase ***/

    for ( int i = 0; i < phrase.length(); i++ )
    {

     /*** If current char is a number, count through the array
          that contains the number chars until the one needed is
          found. ***/

        if ( isNumber( phrase.charAt( i ) ) )
        {
            boolean keepSearching = true;

            int j = 0;

            do
            {
               if ( numberChar[ j ] == phrase.charAt( i ) )
                  keepSearching = false;

               else
                  j++; // Increments j if char doesn't match array element

            } while ( keepSearching && j < numberChar.length );

            /*** Replaces the current char with the corresponding String
                 word from the other number array.  ***/

            phrase = phrase.replace( Character.toString(
                                      phrase.charAt( i ) ) ,
                                      numberWord[ j ] + "-" );
    }
    }

    /*** Gets rid of dashes from unwanted places ***/

    phrase = phrase.replaceAll( "- " , " " );
    phrase = phrase.replaceAll( "-," , ", " );
    phrase = phrase.replace( "-." , "." );

    if ( phrase.charAt( phrase.length() - 1 ) == '-' )
       phrase = phrase.substring( 0 , phrase.length() - 1 );

  return phrase;
}

/*** Observer Methods ***/