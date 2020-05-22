String line[]; 
        do {
            line = input.next().split(",");
            String name = line[0];
            int strength = Integer.parseInt(line[1]);
            int speed = Integer.parseInt(line[2]);
            int numVials = Integer.parseInt(line[3]);
            Enemy newEnemy = new Enemy(name, strength, speed, numVials);
            opponents.add(newEnemy);
            input.close();
        } while (input.hasNext());