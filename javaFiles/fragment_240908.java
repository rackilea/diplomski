for (int i=0 + 1; i< quakes.size()-numSorted; i++) {

    if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
        QuakeEntry qi = quakes.get(i);
        QuakeEntry qmin = quakes.get(minIdx);
        quakes.set(i,qmin);
        quakes.set(minIdx,qi);        
    }
    minIdx = i;  
}