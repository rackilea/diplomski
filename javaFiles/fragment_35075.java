package project;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;


public class Controller implements Initializable
{


    @FXML
    public FlowPane flowPane;


    //A class that implements  Runable, So i can start a thead there
    private MyRunableClass my_run_class; 
    private Thread t; //Thread object

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {       
        new ListOfNames(); //Init list of names and creating Array list, In real program i will get this list from database
        my_run_class = new MyRunableClass(this);

    }





    @FXML
    void clear_Button(ActionEvent event) 
    {
        flowPane.getChildren().clear(); 
    }


    @FXML
    void start_Button(ActionEvent event) 
    {   
        t = new Thread(my_run_class);
        t.start();
    }

    @FXML
    void stop_Button(ActionEvent event) {
        t.suspend(); ///NOT WORKING???????? any way to stop running thread
    }




    private boolean firstTime_thread_running = true; // To check Whether i clicked '1st' time or 'second' time

    @FXML
    void refresh_Button(ActionEvent event) 
    {


        if(firstTime_thread_running == false){


            //Stop
            //  my_run_class.stop = true; //Exist loop
            t.suspend();
            System.out.println("Suspend");

        } else
        {   
            firstTime_thread_running = false;
        }



//Clean
            flowPane.getChildren().clear(); // cleaning screen
            System.out.println("Screen clear");


//Restart , well.. at least that what i want
            t = new Thread(my_run_class);
            t.setDaemon(true);
            t.start(); //Start Thread
            System.out.println("Stoped  Thread Started again"); 

    }



}