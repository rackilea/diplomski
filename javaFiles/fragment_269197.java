for ( int count = 0 ; count < 10 ; count++ ) 
{
    //count = num1(0); 
    g.drawString( String.valueOf(count) , 20  , 20 * ( count + 1 ) );
    g.drawString( String.valueOf(count*count) , 70  , 20 * ( count + 1 ) );
    g.drawString( String.valueOf(count*count*count) , 120 , 20 * ( count + 1 ) );
}