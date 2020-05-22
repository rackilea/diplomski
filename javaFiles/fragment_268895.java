DecaysToV2 anno = getAnnotation( DecaysToV2.class );
if(anno = null)
{
    DecaysTo anno_old = getAnnotation( DecaysTo.class );
    if(anno_old!=null)
       anno = convert (anno_old);
}