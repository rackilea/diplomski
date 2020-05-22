@RestController
    public static class ColorsService {

        @PostMapping(path = "/colors", headers = "Accept=application/json")
        public void generateClaimDocument(@Valid @RequestBody Colors colors) {
            if (colors != null) {
                System.out.println(colors);
            }
        }
    }

    public static class Colors {

        private String blue;
        private String red;
        private Greens greens;
        //getters and setters

        public String getBlue() {
            return blue;
        }

        public void setBlue(String blue) {
            this.blue = blue;
        }

        public String getRed() {
            return red;
        }

        public void setRed(String red) {
            this.red = red;
        }

        public Greens getGreens() {
            return greens;
        }

        public void setGreens(Greens greens) {
            this.greens = greens;
        }

        @Override
        public String toString() {
            return "Colors{" + "blue=" + blue + ", red=" + red + ", greens=" + greens + '}';
        }
    }

    public static class Greens {

        private String lightGreen;
        private String darkGreen;
        //getters and setters

        public String getLightGreen() {
            return lightGreen;
        }

        public void setLightGreen(String lightGreen) {
            this.lightGreen = lightGreen;
        }

        public String getDarkGreen() {
            return darkGreen;
        }

        public void setDarkGreen(String darkGreen) {
            this.darkGreen = darkGreen;
        }

        @Override
        public String toString() {
            return "Greens{" + "lightGreen=" + lightGreen + ", darkGreen=" + darkGreen + '}';
        }
    }