public void simpleInitApp() {
    // Create red transparent material
    Material mat = new Material(getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
    mat.setColor("Color", new ColorRGBA(1, 0, 0, 0.5f)); // 0.5f is the alpha value

    // Activate the use of the alpha channel
    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);

    // Create rectangle of size 10x10
    Geometry mouseRect = new Geometry("MouseRect", new Quad(10, 10));
    mouseRect.setMaterial(mat);
    guiNode.attachChild(mouseRect);
}

public void simpleUpdate(float tpf) {
    // Move the rectangle to the cursor position
    Vector2f cursor = inputManager.getCursorPosition();
    guiNode.getChild("MouseRect").setLocalTranslation(cursor.x, cursor.y, 0);
}