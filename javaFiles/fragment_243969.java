PVector vP1 = new PVector(x - ranX1, y - ranY1);
if ( D.dot( vP1 ) < 0.0 )
    hit = false;

PVector vP2 = new PVector(x - ranX2, y - ranY2);
if ( D.dot( vP2 ) > 0.0 )
    hit = false;