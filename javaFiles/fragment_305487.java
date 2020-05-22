private String buttonLabel;

public Motion(){
    MotionEvent evt = new MotionEvent(this);
}
public static void main(String args[]){
    Motion m = new Motion();
}
public void setButtonLabel(String str){
    this.buttonLabel = str;
}
public String getButtonLabel(){
    return buttonLabel;
}