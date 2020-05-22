public class DragNode {
    private ArrayList<Circle> circles = new ArrayList<Circle>

    private Circle getNearestCircle(DragNode source) {
        Circle nearestCircle = null;
        for (Circle circle : circles) {
            if (nearestCircle == null) {
                nearestCircle = circle;
            } else {
                // If this circle is closer to the target than the current nearest circle, set this circle as the nearestCircle.
            }
        }
        return nearestCircle;
    }

    public void link (DragNode source) {
        // Bind the x and y property of the target and source circle closest to each other.  
        getNearestCircle(source).xProperty.bindBidirectional(source.getNearestCircle(this).xProperty())
        getNearestCircle(source).yProperty.bindBidirectional(source.getNearestCircle(this).yProperty())
    }
}