for (int i = 0; i < obstacles.size; i++) {
         Vector2 obs = obstacles.get(i);
         obs.x -= 400 * deltaTime;
         if (obs.x + obstacle.getWidth() < 250) {
            usedObstacles.add(obs);
            obstaclesToRemove.add(obs);
         }
      }

      for (int i = 0; i < obstaclesToRemove.size; i++) {
         obstacles.removeValue(obstaclesToRemove.get(i), true);

      }
      obstaclesToRemove.clear();