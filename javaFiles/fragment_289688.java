double dot = C.dot(M);
double det = ((C.getX()*M.getZ()) - (C.getZ()*M.getX()));
double angle = Math.toDegrees(Math.atan2(det, dot));

String movedirection = "";
if(angle < -135 || angle >= 135){
movedirection = "Front";
};
if(angle < 135 && angle >= 45){
movedirection = "right";
};
if(angle < 45 && angle >= -45){
movedirection = "back";
};
if(angle < -45 && angle >= -135){
movedirection = "left";
};