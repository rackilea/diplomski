public class GUI extends Application
{

public static void initialize(String[] args)
{
    launch(args);
}

@Override
public void start(Stage mainStage) throws Exception
{
    GuiClass gui1 = new GuiClass();
    GuiClass gui2 = new GuiClass();

    gui1.getGuiSwitchProp().addListener(listener -> {
        if (gui1.getGuiSwitch()) {
            scene.setRoot(gui2.getGui());
            gui1.setGuiSwitch(false);
        }
    });
    gui2.getGuiSwitchProp().addListener(listener -> {
        if (gui2.getGuiSwitch()) {
            scene.setRoot(gui1.getGui());
            gui2.setGuiSwitch(false);
        }
    });

    Scene scene = new Scene(gui.getGui(), 300, 300);
    mainStage.setScene(scene);
    mainStage.show();
}

}