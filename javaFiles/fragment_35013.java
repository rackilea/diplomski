new ColorPoint(4, 2, "purple") //<-- creating ColorPoint object
super(x, y); //<-- super call
this.x = 4; 
this.y = 2;
name = makeName(); //<-- call makeName() in your ColorPoint class
return super.makeName() + ":" + color; //<-- here color isn't defined yet so it's null
name = "[4, 2]:null";
color = "purple";
/***/
print [4, 2]:null in the console //you call the toString() method, since it returns name you get the following output