/*
 * Function to update the position of the Zombie, aka walk to the Player.
 * @player_pos       - Where's the Brainz at?
 * @zombie_pos       - Where am I?
 * Might want to build it overloaded with an option for the speed.
 *
 * @return           - We return the new Zombie pos.
 */
private double [] moveTowardsPlayer(double [] player_pos, double [] zombie_pos) {
    // To make sure we don't override the old position, we copy values. (Java stuff)
    double [] player_pos_old = player_pos.clone();
    double [] zombie_pos_old = zombie_pos.clone();

    // Let's get the new X pos for the Zombie
    double left_or_right = player_pos_old[0] - zombie_pos_old[0]; // pos number is right, neg is left
    double zombie_pos_new_x;
    if (left_or_right > 0) { // Right
        zombie_pos_new_x = player_pos_old[0] + zombie_speed;
    } else { // Left - this way we make sure we are always getting nearer to the Brainz.
        zombie_pos_new_x = player_pos_old[0] - zombie_speed;
    }

     // TODO: do the same for the Y pos.

    // Bring it together
    double [] zombie_pos_new = {zombie_pos_new_x, zombie_pos_new_y};

    // One step closer to the Brainz!
    return zombie_pos_new;
}