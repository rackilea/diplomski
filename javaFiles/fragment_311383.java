public void setMyParamValue(final float newValue){
    queueEvent(new Runnable(){
        public void run(){
           GLES20.glUseProgram(myShaderProgram);
           GLES20.glUniform1f(paramHandle, new_value);
        }
    });
}