x1 = ship.locX;
        y1 = ship.locY;
        x2 = planets.get(i).locX + planets.get(i).radi;
        y2 = planets.get(i).locY + planets.get(i).radi;
        if(Math.abs(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))) < planets.get(i).gravrange){
            //Distance formula between spaceship and planets

            angle = Math.atan2((y2 - y1),(x2 - x1)); //Converts the difference to polar coordinates and returns theta.

            xm -= Math.cos(angle) * planets.get(i).gravrate; //Converts theta to X/Y
            ym -= Math.sin(angle) * planets.get(i).gravrate; //velocity values.
        }