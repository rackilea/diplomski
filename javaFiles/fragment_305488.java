private Motion motion;
public MotionEvent(Motion motion){
    this.motion = motion;

}
public void someMethod(){
    motion.setButtonLabel("SomeTxt");
}