for( int i = 0; i < Elements.length; i ++ ) {
    String[] Current = Elements[ i ];
    String[] New = new String[ MaxLength ];

    // Copy existing values into new array, extra values remain null
    System.arraycopy( Current, 0, New, 0, Current.length );
    Elements[ i ] = New;
}