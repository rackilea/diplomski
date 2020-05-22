int index=text.toLowerCase().indexOf(patteren.toLowerCase(),pos);
    if (index>=0) {
        component.setSelectionStart(index);
        component.setSelectionEnd(index+patteren.length());
        component.getCaret().setSelectionVisible(true);
    }
    else {
        index=text.substring(0,pos).toLowerCase().indexOf(patteren.toLowerCase());
        if (index>=0) {
            component.setSelectionStart(index);
            component.setSelectionEnd(index+patteren.length());
            component.getCaret().setSelectionVisible(true);
        }
    }