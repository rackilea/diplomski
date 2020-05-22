public class Line implements Runnable
    {

        public Line()
        {
            System.out.println("I'm made");
        }

    @Override
    public void run()
    {
      Platform.runLater(new Runnable() {
            @Override
            public void run()
            {
              System.out.println("I've started");
              try
              {
                 Alert alert = new Alert(AlertType.ERROR, "Line is empty");
                 alert.setTitle("Error");
                 alert.setHeaderText("Line empty");
                 System.out.println("I've ended");
              } catch (Exception e) {
                e.printStackTrace();
              }
          }});
     }
}