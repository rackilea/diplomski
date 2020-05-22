Camera cam = this.stage.getCamera();
Frustum f = cam.frustum;
float h = cam.viewportHeight;
float w = cam.viewportWidth;
Matrix4 m = cam.combined; //combind projection matrix
Matrix4 m2= cam.projection; 
... 
...