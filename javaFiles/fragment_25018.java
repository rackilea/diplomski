public class Mouse{

    private static boolean button_left = false, button_right = false;

    public static boolean isButtonDown(int button){
        if(button == 0) return button_left;
        if(button == 1) return button_right;
        return false;
    }

    public static void update(){
        while(org.lwjgl.input.Mouse.next()){
                if(org.lwjgl.input.Mouse.getEventButton() == 0) button_left = org.lwjgl.input.Mouse.getEventButtonState();
            if(org.lwjgl.input.Mouse.getEventButton() == 1) button_right = org.lwjgl.input.Mouse.getEventButtonState();
        }
    }
}