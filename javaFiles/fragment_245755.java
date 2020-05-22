import java.io.IOException;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;


public class Main {
public static void main(String[] args) {
    Controller controller = new Controller();
    Listener listen = new Listener(){

        @Override
        public void onConnect(Controller arg0) {
            super.onConnect(arg0);
            System.out.print("\nOnConnect");
        }

        @Override
        public void onDeviceChange(Controller arg0) {
            super.onDeviceChange(arg0);
            System.out.print("\nOnDeviceChanged");
        }

        @Override
        public void onDisconnect(Controller arg0) {
            super.onDisconnect(arg0);
            System.out.print("\nOnDisconnected");
        }

        @Override
        public void onExit(Controller arg0) {
            super.onExit(arg0);
            System.out.print("\nOnExit");
        }

        @Override
        public void onFocusGained(Controller arg0) {
            super.onFocusGained(arg0);
            System.out.print("\nOnFocusGained");
        }

        @Override
        public void onFocusLost(Controller arg0) {
            super.onFocusLost(arg0);
            System.out.print("\nOnFocusLost");
        }

        @Override
        public void onFrame(Controller arg0) {
            super.onFrame(arg0);
            System.out.print("\nOnFrame");
        }

        @Override
        public void onInit(Controller arg0) {
            super.onInit(arg0);
            System.out.print("\nOnInit");
        }

        @Override
        public void onServiceConnect(Controller arg0) {
            super.onServiceConnect(arg0);
            System.out.print("\nOnServiceConnect");
        }

        @Override
        public void onServiceDisconnect(Controller arg0) {
            //super.onServiceDisconnect(arg0);
            System.out.print("\nOnServiceDisconnect");
        }

    };
    controller.addListener(listen);
    System.out.print("\nKeep proccess until press a key");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}