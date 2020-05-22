Vector2 vel = this.player.body.getLinearVelocity();
Vector2 pos = this.player.body.getPosition();

// apply left impulse, but only if max velocity is not reached yet
if (Gdx.input.isKeyPressed(Keys.A) && vel.x > -MAX_VELOCITY) {          
     this.player.body.applyLinearImpulse(-0.80f, 0, pos.x, pos.y, true);
}

// apply right impulse, but only if max velocity is not reached yet
if (Gdx.input.isKeyPressed(Keys.D) && vel.x < MAX_VELOCITY) {
     this.player.body.applyLinearImpulse(0.80f, 0, pos.x, pos.y, true);
}