public void increaseBrightness( BufferedImage image, RescaleOp rescaleOp )
{
     rescaleOp.filter( image, image );
     // Don't know what updateGreen does but you could probably do something similar there
     updateImage( image );
}