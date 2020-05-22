package com.assec.engine.componentsystem.components;

import com.assec.engine.componentsystem.Component;
import com.assec.engine.eventsystem.engineevents.UpdateEvent;
import com.assec.engine.eventsystem.mouseevents.MouseMovedEvent;
import com.assec.engine.eventsystem.mouseevents.MousePressedEvent;
import com.assec.engine.eventsystem.mouseevents.MouseReleasedEvent;
import com.assec.engine.eventsystem.mouseevents.MouseScrolledEvent;
import com.assec.engine.toolbox.math.SmoothFloat;
import com.assec.engine.toolbox.math.matrix.Matrix4f;
import com.assec.engine.toolbox.math.vectors.Vector3f;

public class CameraComponent extends Component{

    private boolean right = false, left = false;
    private float mouseX = 0.0f, mouseY = 0.0f, oldMouseX, oldMouseY;

    private SmoothFloat distanceFromTarget = new SmoothFloat(-10.0f, 5.0f);
    private SmoothFloat angleAroundTarget = new SmoothFloat(0.0f, 10.0f);

    private SmoothFloat pitch = new SmoothFloat(0.0f, 10.0f);

    private Vector3f position = new Vector3f(0.0f), rotation = new Vector3f(0.0f), target;

    public CameraComponent() {}

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Vector3f getTarget() {
        return target;
    }

    private float calculateHorizontalDistance() {
        return (float) (this.distanceFromTarget.getActual()*Math.cos(Math.toRadians(this.rotation.x)));
    }

    private float calculateVerticalDistance() {
        return (float) (this.distanceFromTarget.getActual()*Math.sin(Math.toRadians(this.rotation.x)));
    }

    public Matrix4f getViewMatrix() {
        Matrix4f result = Matrix4f.identity();

        this.target = new Vector3f(0.0f);

        this.rotation.x = pitch.getActual();
        this.rotation.x%= 360;

        float horizontalDistance = calculateHorizontalDistance();
        float verticalDistance = calculateVerticalDistance();
        float theta = angleAroundTarget.getActual();

        float xOffset = (float) (horizontalDistance*Math.sin(Math.toRadians(theta)));
        float zOffset = (float) (horizontalDistance*Math.cos(Math.toRadians(theta)));

        this.position.x = target.x - xOffset;
        this.position.y = target.y + verticalDistance;
        this.position.z = target.z - zOffset;

        this.rotation.y = 360.0f - theta;
        this.rotation.y%= 360;

        result = result.rotate((float) -this.rotation.x, new Vector3f(1f, 0f, 0f));
        result = result.rotate((float) this.rotation.y, new Vector3f(0f, 1f, 0f));
        result = result.translate(position.negate());

        return result;
    }

    @Override
    public void onAttach() {
        this.target = ((PositionComponent) parent.getComponent(PositionComponent.class)).getPosition();
        this.target = new Vector3f(0.0f);
    }

    @Override
    public boolean onMouseScrolled(MouseScrolledEvent event) {
        this.distanceFromTarget.increaseTarget(-event.getyOffset()*0.7f);
        return false;
    }

    @Override
    public boolean onMousePressed(MousePressedEvent event) {
        if(event.getButton() == 0 && event.getMods() == 1) {
            left = true;
        }
        if(event.getButton() == 1 && event.getMods() == 1) {
            right = true;
        }
        return false;
    }

    @Override
    public boolean onMouseReleased(MouseReleasedEvent event) {
        if(event.getButton() == 0) {
            left = false;
        }
        if(event.getButton() == 1) {
            right = false;
        }
        return false;
    }

    @Override
    public boolean onMouseMoved(MouseMovedEvent event) {
        oldMouseX = mouseX;
        oldMouseY = mouseY;
        mouseX = (float) event.getX();
        mouseY = (float) event.getY();
        if(left) {
            this.angleAroundTarget.increaseTarget(-(mouseX-oldMouseX)*0.1f);
        }
        if(right) {
            this.pitch.increaseTarget(-(mouseY-oldMouseY)*0.1f);
        }
        return false;
    }

    @Override
    public void onUpdate(UpdateEvent event) {
        this.angleAroundTarget.update(0.01f);
        this.distanceFromTarget.update(0.01f);
        this.pitch.update(0.01f);
    }

}