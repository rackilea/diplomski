pointer = true;

public void my_method(){

    if (a==1) {
        y++;
        pointer = false;
    }

    if (b==5) {
        y++;
        pointer = false;
    }

    if (c==10) {
        y++;
        pointer = false;
    }

    if (pointer){
        y=0;
    }

}