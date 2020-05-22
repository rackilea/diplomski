package com.example.ryan.llamaorduck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class DuckScreen extends AppCompatActivity {

boolean isLlamaScreen = false; //false because this is the Duck screen
Intent intent;
int screen; // variable used just for finding the next random screen

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_duck_screen);
}

// user clicked on the llama button.
//method implementation decides if they are correct and either ends the 
//game or moves them onto the next random page.       
public void llamaClick(View view){
    if (isLlamaScreen){
        Random r = new Random();
        screen = r.nextInt(2);
        if (screen == 1){ //DUCK
            intent = new Intent(DuckScreen.this,DuckScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else{
            intent = new Intent(DuckScreen.this,LlamaScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }else{
        intent = new Intent(DuckScreen.this,GameOver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
//user clicked on the button indicating that they think the animal is a
//duck. Same idea as method before, testing other button.         
public void duckClick(View view){
    if (!isLlamaScreen){
        Random r = new Random();
        screen = r.nextInt(2);
        if (screen == 1){ //DUCK
            intent = new Intent(DuckScreen.this,DuckScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else{
            intent = new Intent(DuckScreen.this,LlamaScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }else{
        intent = new Intent(DuckScreen.this,GameOver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
}