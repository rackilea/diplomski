enum Heading {
    None, Up, Down, Left, Right
}
Heading currentHeading = Heading.None;

//if result positive on x move drone left
if(piccX - facecX > 50 && currentHeading != Heading.Left){
    drone.goLeft();
    currentHeading = Heading.Left;                  
}

//if result negative on x move drone right
if(piccX - facecX < 50 && currentHeading != Heading.Right){
    drone.goRight();
    currentHeading = Heading.Right;                  
}

//if result positiveon Y, move drone up
if(piccY - facecY > 50 && currentHeading != Heading.Up){
    drone.up();
    currentHeading = Heading.Up;                  
}

//if result negative on Y, move drone Down
if(piccY - facecY > 50 && currentHeading != Heading.Down){
    drone.down();
    currentHeading = Heading.Down;                  
}