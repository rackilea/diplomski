for (int i = 0; i < bullCount.size(); i++) { // get the current size from the list

    if(bullCount.get(i).getBounds().intersects(enemy.get(0).getBounds())) {
        enemy.remove(0);
        bullCount.remove(i);
        i--; // if you remove an element, the indices of the following elements
             // are decremented, so you should iterate over the same value
             // of i in order not to skip an element
    }