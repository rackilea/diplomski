boolean redOrGreen = true; // true = Green false = Red
int  counter = 0;
int  COLORCHANGEAT = 30;

while ( glfwWindowShouldClose(window) == GL_FALSE ) {

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

    counter++;
    if(counter == COLORCHANGEAT) {      
       redOrGreen = !redOrGreen;
       counter = counter % COLORCHANGEAT;
    }

    if(redOrGreen == true)
       glClearColor(1.0f, 1.0f, 0.0f, 0.0f);
    else        
       glClearColor(0.0f, 1.0f, 0.0f, 0.0f);

    glfwSwapBuffers(window); // swap the color buffers

    // Poll for window events. The key callback above will only be
    // invoked during this call.
    glfwPollEvents();
}