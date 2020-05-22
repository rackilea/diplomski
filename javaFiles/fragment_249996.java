Iterator<ParticleBlast> itr = particles.iterator();
while(itr.hasNext())
{
    ParticleBlast next = itr.next();
    if(next.hasExpired()) itr.remove();
}