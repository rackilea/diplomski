if (mp == null) {
    mp = new MaskerPane();
    stackPane.getChildren().add(mp);
    mp.setVisible(false);
}
mp.setVisible(true);
Runnable task = () -> {
    try {

        JSONObject verifyKey = new Network().verifyKey(pinF.getText(), phoneF.getText(), mp);
        if (verifyKey != null) {
            String string = verifyKey.getString("ans");

//Updating ui from another thread need you to use Platform.runLatter... So wrapping the below with runLatter to avoid exceptions
            mp.setVisible(false);
            if (string.equals("1")) {
                // Thanks for buying

            } else {
                error.setText("Key already used");
                error.setVisible(true);
            }
        }

        Thread back = new Thread(task);
        back.setPriority(Thread.MAX_PRIORITY);
        back.setDaemon(true);
        back.start();

    } catch (JSONException ex) {
        mp.setVisible(false);
        Logger.getLogger(Buy.class.getName()).log(Level.SEVERE, null, ex);
    }

}
        // Run the task in a background thread
Thread back = new Thread(task);
back.setPriority(Thread.MAX_PRIORITY);
back.setDaemon(true);
back.start();