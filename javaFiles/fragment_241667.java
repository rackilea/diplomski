public Rectangle resize(float width, float height){

    float aspectRatio = (float)width/(float)height;
    float scale = 1.0f;
    Vector2 crop = new Vector2(0f, 0f); 

    if(aspectRatio > getAspectRatio())
    {
        scale = (float)height/(float)getVirtualLandHeight();
        crop.x = (width - getVirtualLandWidth()*scale)/2f;
    }
    else if(aspectRatio < getAspectRatio())
    {
        scale = width/(float)getVirtualLandWidth();
        crop.y = (height - getVirtualLandHeight()*scale)/2f;
    }
    else
    {
        scale = (float)width/(float)getVirtualLandWidth();
    }

    float w = (float)getVirtualLandWidth()*scale;
    float h = (float)getVirtualLandHeight()*scale;

    Rectangle viewport = new Rectangle(crop.x, crop.y, w, h);

    return viewport;
}

public float getAspectRatio(){
    return getVirtualLandWidth() / getVirtualLandHeight();
}