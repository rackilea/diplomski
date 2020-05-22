if (hitbox1.intersects(hitbox)) {
      System.out.println("you win");
      a = randomgenerator.nextInt(1220);
      b = randomgenerator.nextInt(720);
      repaint();
      score = score + 1;
}