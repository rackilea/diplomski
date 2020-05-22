public static JFrame enterFrameDraw(JFrame frame){
    //...
    btnEnter.addActionListener(e -> {
        try{
            Chat.btnEnterHandler(frame);
        } catch (Exception e2){
            e2.printStackTrace();
        }
    });