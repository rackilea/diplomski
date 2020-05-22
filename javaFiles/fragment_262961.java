float ox = Math.abs(xAxis - cw); //overlap on x
float oy = Math.abs(yAxis - ch); //overlap on y

//direction
Vector2f dir = new Vector2f(this.position); 
dir.sub(other.getPosition()); //subtract other.position from this.position
dir.normalise();

return new Vector2f(dir.x * ox, dir.y * oy);