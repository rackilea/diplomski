btn.setOnAction(event -> {
    new Thread(() -> {
         for(int i = 0; i <=100; i++){
            final int position = i;
            Platform.runLater(() -> {
                pb.setProgress(position/100.0);
                System.out.println("Index: " + position);
            });
            try{
                Thread.sleep(100);
            }catch(Exception e){ System.err.println(e); }
         }
    }).start();
});