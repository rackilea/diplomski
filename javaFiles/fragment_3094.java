package com.springpractice.app;

import org.springframework.stereotype.Component;

@Component("camera") 
public class Camera implements PhotoSnapper {

    public Camera() {
        //System.out.println("Hello from constructor");
    }

    public void snap() {
        System.out.println("Snaped a picture...");
    }

    public void snap(int exposure) {
        System.out.println("Exposure.."+exposure);
    }
}