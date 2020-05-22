for(int i = 0; i < 3; i ++){
    String currentI = item[i];

    if(source.equals(btnNxt)){
        txtDisplayField.setText(currentI);
        // stop iteration as you already found a match
        break;
    }
}