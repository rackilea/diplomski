//stores history
if(choice != 4){
    String temp = new String[hist.length];
    for(int x = 0; x < hist.length; x++){
        temp[x] = hist[x];
    }
    temp[hist.length] = menu[choice - 1];
    hist = temp;
}