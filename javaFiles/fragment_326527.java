Stack<Particle> particles = new Stack<Particle>();
... // Add a bunch of particles
Iterator<Particle> iter = particles.iterator();
while (iter.hasNext()) {
    Particle p = iter.next();
    if (!p.isAlive()) {                
        iter.remove();            
    }
}