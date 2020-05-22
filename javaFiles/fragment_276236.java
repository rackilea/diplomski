class GUI {
    private ImageProcessor imager = new ImageProcessor();
    private ImageProcessor[] LAMBDAS = new ImageProcessor[] {
            //LAMBDAS[0]
            new ImageProcessor() {
                public void blur() {
                    imager.blur();
                }
            },

            //LAMBDAS[1]
            new ImageProcessor() {
                public void blur() {
                    imager.blur();
                }
            } };
}