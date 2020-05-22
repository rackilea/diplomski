public void ChangeView(View view) {
    //here we put number of cards that we want to be scaled and displayed (cards=buttons)
    int CardMax=13;//13 for example!!!

    //getting scale for dpi of phone screen(i think??)
    final float scale = getResources().getDisplayMetrics().density;
    // getting some values we need to know
    // **THESE VALUES DEPEND FROM SCREEN RESOLUTION OR THE SIZE OF BUTTON**
    int layWidth = layout.getWidth();  //getting layout width that equals screen width(in pixels)
    int btnWidth = (int) (50 * scale); //setting and scaling the width of the button for any screen
    int maxLayfit=layWidth/btnWidth;   //getting how many buttons can be added to layout without deformation
    int layMidWidth = layWidth / 2;    //getting layouts half width (that helps to start adding buttons from middle)
    int StrMeasur;                     // this help how to start setting the buttons
    if (CardMax <= maxLayfit) {        // if cards are less than Layout can hold without deformation
        StrMeasur = CardMax;           // StrMeasur equals number of cards
    } else {
        StrMeasur = maxLayfit;         // else equals max number of cards without deformation
    }
    int pointer=0;                     //pointer that will say where to put the first button
    pointer = layMidWidth - ((btnWidth / 2) * StrMeasur);//depends of how many cards we have and button width
    int start =layMidWidth-((btnWidth / 2) * StrMeasur);
    int nextBtn = 0;                   //nextBtn says where to put the next button
    //here we set the buttons on top and next to the previous button as we need **TRICKY PART**
    if (CardMax > maxLayfit-1) {       //if number of cards is bigger than the number the layout can hold
                                       //then we calculate first card position (start/pointer) and the last card position(=layout width-button width)
                                       //we find how many equal parts the layout has to be divided with the given cards
                                       //and we get the width of the part to set it as pointer of the next card place
        nextBtn =(((layWidth-start)-btnWidth)-start)/CardMax;
    }else{
        nextBtn=btnWidth;              //else the pointer just set buttons next to the other
    }
    //Here we display all the buttons
    for (int i = 0; i < CardMax; i++) {
        Button cards = new Button(this);
        cards.setWidth(btnWidth);
        cards.setHeight((int) (90 * scale));
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params2.setMargins(pointer, 0, 0, 0);
        cards.setLayoutParams(params2);
        cards.setText("" + (i + 1));
        cards.setId(i);
        layout.addView(cards);
        pointer = pointer + nextBtn;
    }
}