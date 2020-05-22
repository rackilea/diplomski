if(input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON))
    {
        length = (float) Math.sqrt((player_waypoint_X - player_X)*(player_waypoint_X - player_X) + (player_waypoint_Y - player_Y)*(player_waypoint_Y - player_Y));
        velocityX = (float) (player_waypoint_X - player_X) /length * (float) PlayerStats.player.db_player_Speed;
        velocityY = (float) (player_waypoint_Y - player_Y) /length * (float) PlayerStats.player.db_player_Speed; 

        player_waypoint_X = input.getMouseX() - 2;
        player_waypoint_Y = input.getMouseY() - 2;

    }