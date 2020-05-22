abstract class SVGElement {

    public void draw (void) {
        return;
    }

    public boolean hasWidth (void) {
        return false;
    }

    public boolean hasHeight (void) {
        return false;
    }

    // ..
}

// An abstract decorator
abstract class SVGElementDecorator extends SVGElement {

    protected SVGElement decoratedElement;

    public SVGElementDecorator (SVGElement decoratedElement) {
        this.decoratedElement = decoratedElement;
    }

    public void draw (void) {
        decoratedElement.draw ();
    }
}

// Decorator to add width functionality
class WidthDecorator extends SVGElementDecorator {

    private double width;

    public WidthAndHeightDecorator (SVGElement decoratedElement) {
        super(decoratedElement);
    }

    // override base class implementation
    public boolean hasWidth (void) {
        return true;
    }

    // implement a new method
    public double getWidth (void) {
        return width;
    }

    public void draw (void) {

        // do special stuff for width
        // ..

        // then draw the rest
        decoratedElement.draw ();
    }
}