if((planet.position.x != otherPlanet.position.x && planet.position.y != otherPlanet.position.y) && !otherPlanet.delete)
        {
            //First we get the x,y and magnitudal distance between the two bodies.
            float xDist = (otherPlanet.position.x - planet.position.x);
            float yDist = (otherPlanet.position.y - planet.position.y);
             // add a limit to xDist and yDist
             if(xDist<5)
                xDist=5;
             if(yDist<5)
                yDist=5;
            float dist = Vector2Math.distance(planet.position, otherPlanet.position);

            //Now we compute first the total and then the component forces
            //Depending on choice, use r or r^2
            float force = Constants.GRAVITATIONAL_CONSTANT * ((planet.mass*otherPlanet.mass)/(dist*dist)); 
            float forceX = force * xDist/dist;
            float forceY = force * yDist/dist;

            //Given the component forces, we construct the force vector and apply it to the body.
            Vector2 forceVec = new Vector2(forceX, forceY);
            planet.force = Vector2Math.add(planet.force, forceVec);
            otherPlanet.force = Vector2Math.subtract(otherPlanet.force, forceVec);
        }