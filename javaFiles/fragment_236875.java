public static void btnEnterHandler(JFrame frame) throws Exception{
    JFrame mainFrame = Forms.mainFrameDraw(new Chat());
    try{
        frame.dispose();
        mainFrame.setVisible(true); //i'm pretty sure its not necessary because its visible by default
    } catch(Exception ex2) {
        Logger.getLogger(enterFrame.getName());
    }
}