From Java:

 for(int i=0;i<numParticles;i++)
 {
     for(int j=0;j<numParticles;j++)
       {

           particle.get(i).calculateAndAddForce(particle.get(j));
       }
 }


 To a Jocl kernel string(actually very similar to calculateAndAddForce's inside):

   "__kernel void nBodyGravity(__global float * positions,__global float *forces)" +
                "{" +
                "    int indis=get_global_id(0);" +
                "    int totalN=" + n + "; "+            
                "    float x0=positions[0+3*(indis)];"+
                "    float y0=positions[1+3*(indis)];"+
                "    float z0=positions[2+3*(indis)];"+
                "    float fx=0.0f;" +
                "    float fy=0.0f;" +
                "    float fz=0.0f;" +
                "    for(int i=0;i<totalN;i++)" +
                "    { "+
                "       float x1=positions[0+3*(i)];" +
                "       float y1=positions[1+3*(i)];" +
                "       float z1=positions[2+3*(i)];" +

                "       float dx = x0-x1;" +
                "       float dy = y0-y1;" +
                "       float dz = z0-z1;" +
                "       float r=sqrt(dx*dx+dy*dy+dz*dz+0.01f);" +
                "       float tr=0.1f/r;" +
                "       float tr2=tr*tr*tr;" +
                "       fx+=tr2*dx*0.0001f;" +
                "       fy+=tr2*dy*0.0001f;" +
                "       fz+=tr2*dz*0.0001f;" +

                "    } "+


                "    forces[0+3*(indis)]+=fx; " +
                "    forces[1+3*(indis)]+=fy; " +
                "    forces[2+3*(indis)]+=fz; " +

               "}"