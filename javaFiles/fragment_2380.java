public void onControlChange(final BaseOnScreenControl pBaseOnScreenControl, final float pValueX, final float pValueY) {
            final Body carBody = CityRacerActivity.this.mCarBody;

            final float rotationInRad = (float)Math.atan2(-pValueX, pValueY);

            if ((pValueX == 0) && (pValueY == 0))
            {
                    //Don't turn the body/sprite of the car


            }else
            {
                    carBody.setTransform(carBody.getWorldCenter(), rotationInRad);
                    //turn the car body in the direction of movement
                    CityRacerActivity.this.mCar.setRotation(MathUtils.radToDeg(rotationInRad));
            }

            //set the velocity
            final Vector2 velocity = Vector2Pool.obtain(pValueX * 5, pValueY * 5);
            carBody.setLinearVelocity(velocity);
            Vector2Pool.recycle(velocity);
        }