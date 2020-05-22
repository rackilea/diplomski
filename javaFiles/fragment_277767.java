Iterator itr = particleArr.iterator();
while(itr.hasNext()) {
   Particle b = (Particle)itr.next();
   if (b.isDead())
      itr.remove();
}