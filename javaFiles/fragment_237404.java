projMatrix.setIdentity();
projMatrix.setDump(ARNativeActivity.getProjectM());
projMatrix.transformToGL();
SimpleVector translation = projMatrix.getTranslation();
SimpleVector dir = projMatrix.getZAxis();
SimpleVector up = projMatrix.getYAxis();
cameraController.setPosition(translation);
cameraController.setOrientation(dir, up);

model.clearTranslation();
model.clearRotation();

transformM.setIdentity();
transformM .setDump(ARNativeActivity.getTransformationM());
transformM .transformToGL();

modelM.setIdentity()
//do whatever you want to your model
modelM.rotateZ((float)Math.toRadians(180));

modelM.matMul(transformM);

model.setRotationMatrix(modelM );  
model.setTranslationMatrix(modelM);