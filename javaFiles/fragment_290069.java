#function drawAxe:
    translate(player.x, player.y);
    translate(pickaxis.x, pickaxis.y);
    rotation=toDegrees(atan2(mouse.y-player.y,mouse.x-player.x));
    rotate(roation);
    translate(-axisPointOnPickaxe.x, -axisPointOnPickaxe.y);
    drawImage(pickaxe.texture);
    IdentityMatrix();//[[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]] or no transformation. i think you have to set a blank transform to do this in java efficiently
#endFunction drawAxe