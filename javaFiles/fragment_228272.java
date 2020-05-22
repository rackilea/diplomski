public void initilize() {
   ...
   // set data for vHandle
   glBindBufferARB(GL_ARRAY_BUFFER_ARB, vHandle);
   glBufferDataARB(GL_ARRAY_BUFFER_ARB, vBuffer, GL_STATIC_DRAW_ARB);
   glVertexPointer(3, GL_FLOAT, /* stride */3 << 2, 0L);

   // ... setup other handles
   ...
}


public void draw() {
   ...
   glBindBufferARB(GL_ARRAY_BUFFER_ARB, vHandle);

   // ... bind other buffers

   glDrawElements(GL_TRIANGLES, /* elements */6, GL_UNSIGNED_SHORT, 0L);
   ...
}