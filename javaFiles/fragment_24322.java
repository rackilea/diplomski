private static boolean isWindowActive = false; //for window active.
public przybornik() {
    initComponents();
    if(isWindowActive == false){ //window active check here.
     setVisible(true);
     isWindowActive = true;
    }
}