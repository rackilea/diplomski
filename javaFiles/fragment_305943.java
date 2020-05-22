java.util.List<Interval> gaps = new java.util.ArrayList<Interval>();

DateTime gapStart = null, gapStop = null;
for ( int i = 0; i < classes.size(); i++ ) {
    // For each class, take the prior class' end as the gap's beginning, and the next class' start as the gap's ending.
    Interval session = classes.get( i ); // Cannot name the var "class" because that is a keyword in Java.
    if ( i == 0 ) { // If first time through, grab the end of the first class as our first gap's start.
        gapStart = session.getEnd();
        continue;
    }
    gapStop = session.getStart();
    Interval gap = new Interval( gapStart, gapStop );
    gaps.add( gap );
    gapStart = session.getEnd();
}

System.out.println( "gaps: " + gaps );