public void increaseBrightness( BufferedImage image )
{
     RescaleOp rescaleOp = new RescaleOp( 1.0f, 10, null );
     rescaleOp.filter( image, image );
     // Don't know what updateGreen does but you could probably do something similar there
     updateImage( image );
}