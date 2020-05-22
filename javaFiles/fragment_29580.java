Try this code i think it will help you but i am not sure in my case it works fine

Random random = new Random( System.currentTimeMillis() );
List<Integer> generated = new ArrayList<Integer>();
for (int i = 0; i < imageViews.length; i++) {

    int v = imageViews[i];
    int next = random.nextInt( 15 ) + 1;
    if ( !generated.contains( next ) ) {
        generated.add( next );
        ImageView iv = (ImageView) findViewById( v );
        iv.setImageResource( images[next] );
    }
    else {
        i--;
    }
}