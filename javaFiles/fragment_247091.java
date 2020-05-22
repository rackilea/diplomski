// ...

for(int column = 0; column < 4; column++) {
    //column++ is underlined and causes the "dead Code" warning
    if(gw.buttons[line][column].getIcon().equals(gw.red));

    if(gw.buttons[line][column+1].getIcon().equals(gw.red));

    if(gw.buttons[line][column+2].getIcon().equals(gw.red));

    if(gw.buttons[line][column+3].getIcon().equals(gw.red));

    return true;
}

// ...