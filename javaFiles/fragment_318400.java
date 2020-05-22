class RectangularContainer extends Container {
    double height, width, length;

    RectangularContainer(double height, double width, double length) {
         this.height = height;
         this.width = width;
         this.length = length;
    }

    double getTopArea() {
         return height*width;
    }

    double getTopPerimeter() {
         return 2*(height+width);
    }

    double getVolume() {
         return height*width*height;
    }

    double getSurfaceArea() {
         // ooh I can't remember this one... try to figure out this :)
    }

}