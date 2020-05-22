boolean shipFound = false;
for(Ship eachShip: shipList) {
        if((eachShip.getShipName().equals(newShipName)) && (eachShip.getInService() == true)) {
            shipFound=true;
            break;
        }
    }
if(shipFound)
// Do what you want