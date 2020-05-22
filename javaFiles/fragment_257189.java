Page result = new Page1().conditionalAction( true );
if ( result instanceof Page1 ){
    Page1 page1 = (Page1) result;
} else if ( result instanceof Page2 ){
    Page2 page2 = (Page2) result;
}