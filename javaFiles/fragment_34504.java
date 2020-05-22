package com.example.yo;

import processing.core.*;

class Dot{
    //declaration of dot's fields
    public float xpos;
    public float ypos;
    public int redd;
    public int greenn;
    public int bluee;
    public Boolean through = false;
    PApplet parent;

    //constructor
    Dot(PApplet p, float xPosition, float yPosition, int redness, int greenness, int blueness){
        parent = p;
        xpos = xPosition;
        ypos = yPosition;

        redd = redness;
        greenn = greenness;
        bluee = blueness;
    }
    public void display(){
        parent.noStroke();
        parent.fill(redd,greenn,bluee);

        if (through){        
            parent.ellipse(xpos, ypos, 4.0f, 4.0f);
        }else{
            parent.ellipse(xpos, ypos, 30.0f, 30.0f);
        }       
    }   
}