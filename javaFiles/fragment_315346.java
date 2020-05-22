CD temp = new CD(" ", " ");
    for (int i = 0; i <= CDlist.length; i++) {
        if(i<CDlist.length-1){
        if (CDlist[i].getArtist().compareTo(CDlist[i + 1].getArtist()) < 0) {
            temp = CDlist[i];
            CDlist[i] = CDlist[i + 1];
            CDlist[i + 1] = temp;
        }
    }
    }
}