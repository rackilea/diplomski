// clh is a fictional class that binds oepncl to opengl through interoperability
 // registering needed kernels to this object
 clh.addKernel(
               kernelFactory.fluidDiffuse(1024,1024),  // enumaration is fluid1
               kernelFactory.fluidAdvect(1024,1024),   // enumeration is fluid2
               kernelFactory.rigidBodySphereSphereInteracitons(2048,32,32), 
               kernelFactory.fluidRigidBodyInteractions(false), // fluidRigid
               kernelFactory.rayTracingShadowForFluid(true),
               kernelFactory.rayTracingBulletTargetting(true),
               kernelFactory.gravity(G),
               kernelFactory.gravitySphereSphere(), // enumeration is fall
               kernelFactory.NNBotTargetting(3,10,10,2,numBots) // Encog
               );

 clh.addBuffers(
         // enumeration is buf1 and is used as fluid1, fluid2 kernels' arguments
               bufferFactory.fluidSurfaceVerticesPosition(1024,1024, fluid1, fluid2),
        // enumeration is buf2, used by fluid1 and fluid2
               bufferFactory.fluidSurfaceColors(1024,1024,fluid1, fluid2),
        // enumeration is buf3, used by network
               bufferFactory.NNBotTargetting(numBots*25, Encog)
               )

 Running kernels:

 // shortcut of a sequence of kernels
 int [] fluidCalculations = new int[]{fluid1,fluid2,fluidRigid, fluid1} 

 clh.run(fluidCalculations); // runs the registered kernels
 // diffuses, advects, sphere-fluid interaction, diffuse again

 //When any update of GPU-buffer from main-memory is needed:

 clh.sendData(cpuBuffer, buf1); // updates fluid surface position from main-memory.