batch.setProjectionMatrix(camrotate.combined);
batch.begin();
//draw in camrotate now
//...
//...
batch.end();

batch.setProjectionMatrix(camfixed.combined);
batch.begin();
//draw fixed elements now
//...
//...   
batch.end();
//add one more camera if you need