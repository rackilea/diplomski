static class OnClickListener$1 implements OnClickListener {
        private final NewPlanet ref;
        OnClickListener$1(NewPlanet ref) {
           this.ref= ref;
        }

        @Override
        public void onClick(View v) {
            WorldGen mars = new WorldGen("Mars", 642, 3.7);
            mars.setPlanetColonies(1);
            Toast.makeText(ref, "Mars Created", Toast.LENGTH_SHORT).show();
        }
    }