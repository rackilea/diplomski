try{
        readData = new Scanner(new File("src/2particle-initial.data"));
    }
    catch(Exception e){
        System.out.println("Could not find file");
    }

    count = readData.nextInt();

  Particle [] listParticles = new Particle[count];