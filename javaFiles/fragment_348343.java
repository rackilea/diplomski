void setPanel(String str){
    CardLayout layout = (CardLayout)jPanel1.getLayout();
    if("runserver".equals(str)){
        layout.show(jPanel1, "card4");

    }else if("connectserver".equals(str)){
       layout.show(jPanel1, "card3");

    } else{
        layout.show(jPanel1, "card2");
    }
}