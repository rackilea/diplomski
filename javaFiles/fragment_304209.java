public abstract class GameShape {

        //x and y coordinates, still unassigned
        public int[] polyXArray, polyYArray;

        private Polygon polygon;

        //other class variables
        {...}

        public GameShape() {
            instantiatePolyArrays();
            this.polygon = new Polygon(polyXArray, polyYArray, polyXArray.length);
        }

        protected abstract void instantiatePolyArrays();

        public final Polygon getPolygon(){
            return this.polygon;
        }
}