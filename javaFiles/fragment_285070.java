public class MouseWindowQueryImpl implements MouseWindowQuery {

    @Override
    public boolean isMouseInsideWindow() {

        return Mouse.isInsideWindow();
    }
}