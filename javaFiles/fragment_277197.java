for(Control c : list) {
        if(c instanceof ComboBox){
            ComboBox cB = (ComboBox) c;
            ...
        } else {
            TextField tF = (TextField) c;
            ...
        }
    }