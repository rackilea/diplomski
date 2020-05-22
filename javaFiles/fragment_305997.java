public void mkCannonball(){

  Vector2D shipPos = new Vector2D(direction);
  shipPos.normalise().mult(this.radius +2).add(position);

  Vector2D leftBulletTrajectory = new Vector2D(direction - 1);
  Vector2D rightBulletTrajectory = new Vector2D(direction + 1);

  leftBulletTrajectory.normalise().mult(Constants.BULLET_SPEED).add(velocity);
  rightBulletTrajectory.normalise().mult(Constants.BULLET_SPEED).add(velocity);

  leftCannonball = new Cannonball(new Vector2D(shipPos), new Vector2D(leftBulletTrajectory));
  rightCannonball = new Cannonball(new Vector2D(shipPos), new Vector2D(rightBulletTrajectory));

  SoundManager.fire();
}