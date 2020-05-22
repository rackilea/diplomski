Arrays.asList(myframe.getComponents()).forEach((c) -> {
    if( c instanceof JLabel) {
        JLabel l = (JLabel)c;
        //do whatever you'd like to do with your label here...
    }
});