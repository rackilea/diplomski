public void paint(Graphics g)  
/*
Above The name of the method, methods are ways (re-usable blocks of code) of operating on objects
public means the method can be called from outside or inside it's package
void means that the method does not return a value, 
for example if void was changed to int, then this method would give out an int value when run
the 'g' is a variable of type Graphics which is local to this method. The g can be changed to    
any legal variable name and it will only affect the code within the method as that is where it is used.  
So if you changed g to helloMyNameIsEarl for example, all the places where g is referenced
in the code below would error, until you swapped wherever g is referenced to helloMyNameIsEarl
eg helloMyNameIsEarl.setColor(Color.WHITE);

*/
{   
g.setColor(Color.WHITE);
g.fillRect(0, 0, 800, 480);
g.setColor(Color.BLUE);
g.drawRect(60, 200, 100, 250);
g.setColor(Color.BLACK);
g.drawString("My name is James", 200, 400);    

/*
All of the above g.something(something, something) are methods being called on g, which is     referencing the 
Graphics object passed to it (Look up pass by value in java methods) so your method you have is     receiving a 
Graphics object and performing the operations between the { } on it.
*/
}