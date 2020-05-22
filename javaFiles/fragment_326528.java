try {
   ... // above code using iterator.remove
} catch(UnsupportedOperationException e) {
    Log.w(TAG, "Problem removing from stack using iterator: " + e);
    // The platform apparently didn't like the efficient way to do this, so we'll just 
    // loop through a copy and remove what we don't want from the original
    ArrayList<Particle> copy = new ArrayList<Particle>(particles);
    for (Particle p : copy) {
        if (!p.isAlive()) {                
            particles.remove(p);                
        }
    }
}