jump = true;
if(jumpHeight < 100){
  jumpHeight += 5;
  getPlayer().getPos().y -=5;
} else if (jumpHeight < 200){
  jumpHeight +=5;
  getPlayer().getPos().y +=5;
}
break;