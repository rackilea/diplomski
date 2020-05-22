public class Camera
{
    public final static Camera VIEW = new Camera();
    //
    public Vector3 position; 
    public Vector3 directionalVelocity, angularVelocity;
    public Vector3 rotation;
    public Vector3 cameraDirectionVector; // vector pointing in direction of camera

    public Camera()
    {
        this.position = new Vector3(0,0,0);
        this.rotation = new Vector3(0,0,0);
        this.directionalVelocity = new Vector3(0, 0, 0);
        this.angularVelocity = new Vector3(0, 0, 0);
        this.cameraDirectionVector = new Vector3(0, 0, 0);
        Mouse.setGrabbed(true);
    }
    public void setPosition(float x, float y, float z)
    {
        this.position.set(x, y, z);
    }
    public void setRotation(float x, float y, float z)
    {
        this.rotation.set(x, y, z);
    }

    private float walkAcc = 0.2f;
    private float mouseAcc = 0.2f;

    public void update()
    {
        GL11.glLoadIdentity(); // reset matrix
        GL11.glRotatef(rotation.x, 1, 0, 0);
        GL11.glRotatef(rotation.y, 0, 1, 0);
        GL11.glRotatef(rotation.z, 0, 0, 1);
        GL11.glTranslatef(position.x, position.y, position.z);
        //
            // mouse Input , increment angularVelocity
        if(Mouse.isGrabbed())
        {
            float mouseX = Mouse.getDX() * mouseAcc;
            float mouseY = Mouse.getDY() * mouseAcc;
            if(mouseY > 0 && this.rotation.x > -90)
                this.angularVelocity.x -= mouseY;
            if(mouseY < 0 && this.rotation.x < 90)
                this.angularVelocity.x += -mouseY;
            if(mouseX > 0)
                this.angularVelocity.y += mouseX;
            if(mouseX < 0)
                this.angularVelocity.y -= -mouseX;
                    // slow down mouse velocity
            this.applyFriction(this.angularVelocity, 0.4f);  
        }
        //
            // Keyboard input , add direction to velocity
        if(Keyboard.isKeyDown(Keyboard.KEY_W))
            this.walkForward(this.walkAcc);
        if(Keyboard.isKeyDown(Keyboard.KEY_S))
            this.walkBackwards(this.walkAcc);
        if(Keyboard.isKeyDown(Keyboard.KEY_D))
            this.strafeRight(this.walkAcc);
        if(Keyboard.isKeyDown(Keyboard.KEY_A))
            this.strafeLeft(this.walkAcc);
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            this.directionalVelocity.y -= walkAcc;
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            this.directionalVelocity.y += walkAcc;
            //
        //slow down walk speed
        this.applyFriction(this.directionalVelocity, 0.09f);
        //
            // add velocity to position
        this.position.add(this.directionalVelocity);
        this.rotation.add(this.angularVelocity);
        //
        this.updateCameraDirectionVector();
    }

   // Calculates a vector pointing in the direction of your cross hair
    public Vector3 updateCameraDirectionVector() 
    {

        //x = rsin(angle1)cos(angle2)
        //y = rsin(angle1)sin(angle2)
        //z = rcos(angle1)

        this.cameraDirectionVector.x = (float) (Math.sin(Math.toRadians(rotation.y)) * Math.cos(Math.toRadians(rotation.x)));
        this.cameraDirectionVector.z = (float) (-Math.cos(Math.toRadians(rotation.y)) * Math.cos(Math.toRadians(rotation.x)));
        this.cameraDirectionVector.y = (float) -Math.sin(Math.toRadians(rotation.x)); // good
        return this.cameraDirectionVector;
    }
    public void applyFriction(Vector3 vector, float speed)
    {
        //add a percentage of opposite direction to current direction
        vector.x += -vector.x * speed;
        vector.y += -vector.y * speed;
        vector.z += -vector.z * speed;
    }
    public void walkForward(float distance)
    {
        this.directionalVelocity.x -= this.cameraDirectionVector.x * distance;
        this.directionalVelocity.y -= this.cameraDirectionVector.y * distance;
        this.directionalVelocity.z -= this.cameraDirectionVector.z * distance;

    }
    public void walkBackwards(float distance)
    {
        this.directionalVelocity.x += this.cameraDirectionVector.x * distance;
        this.directionalVelocity.y += this.cameraDirectionVector.y * distance;
        this.directionalVelocity.z += this.cameraDirectionVector.z * distance;

    }
    public void strafeLeft(float distance)
    {
        // cross product with (0,1,0) ... y unit vector..
        this.directionalVelocity.x += -this.cameraDirectionVector.z * distance;
        this.directionalVelocity.z += this.cameraDirectionVector.x * distance;

    }
    public void strafeRight(float distance)
    {
        // cross product with -(0,1,0) ... y unit vector..
        this.directionalVelocity.x -= -this.cameraDirectionVector.z * distance;
        this.directionalVelocity.z -= this.cameraDirectionVector.x * distance;

    }
    @Override
    public String toString()
    {
        return this.position.x + " " + this.position.y + " " + this.position.z;
    }
}