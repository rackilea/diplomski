boolean playerStands = false; //if player stands on any platform
for (Rectangle rectangle : plRec) {
    if (/*same condition*/) {
        playerStands = true;
        break; //no need to check the other ones
    } //no else
}
gravity = playerStands ? 0 : 5;