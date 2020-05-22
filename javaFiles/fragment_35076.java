package project;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class MyRunableClass implements Runnable
{       
    private Controller controller;

    public MyRunableClass(Controller controller)
    {   
        //Getting FXML Controller
        this.controller = controller;
    }

//  public boolean stop = false;

    @Override
    public void run()
    {



        for (String name : ListOfNames.getlist()) 
        {
//          if(stop)    // Exit for loop if true
//          {
//              break;
//          }
            Platform.runLater(new Runnable()
            {

                @Override
                public void run()
                {   

                    Button btn = new Button("Button : "+name);

                    System.out.println(name);

                    controller.flowPane.getChildren().add(btn);
                }
            });

            try {
                Thread.sleep(1); // Wait for half sec this time
            } catch (InterruptedException e) { // try catch it needed for some reason
                e.printStackTrace();
            }

        }


    }

}