class PowerUps {
    class Shield {
        private boolean active = false;

        public void enable() {
            active = true;
        }

        public void disable() {
            active = false;
        }
    }
    public void Check() {
        if (shield.active){

            draw(shieldSprite);

        }
    }
}