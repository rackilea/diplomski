for( int i=1; i<=3; i++ ) {
    x = 0;
    for( y=375-((i-1)*50; y>0; y-=50, x+=40 ) {
        children[i].add(new JButton((String)i), new XYConstraints(x, y, w, i*h));
    }
}