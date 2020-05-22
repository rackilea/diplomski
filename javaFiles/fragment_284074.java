@Override
public void addMember(Canvas component) {
    if (!Rect.class.isInstance(component)) {
        throw new IlligalArgumentException("Only Rect is accepted. Sorry...");
    }
}