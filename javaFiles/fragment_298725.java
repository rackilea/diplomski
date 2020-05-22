if(PP1_UP == true){
        P1_Y -= PP_Velocity * dt; 
        P1_Hit_Y -= PP_Velocity *dt;
        // Check paddle inside wall
        if((P1_Y < 0) ) {
            P1_Y = 0;
            P1_Hit_Y = 0;
        }
    }
    // Paddle 1 Down with S
    if(PP1_DOWN == true){
        P1_Y += PP_Velocity * dt; 
        P1_Hit_Y += PP_Velocity *dt;
        // Check paddle inside wall
        if(P1_Y > game_height-PP1_height){
            P1_Y = game_height-PP1_height;
            P1_Hit_Y = game_height;
        }

    }