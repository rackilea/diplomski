public void startAnim() //In different class, pacman.java
{
                            final int  cnt  = 2;
    Image[] imgs = new Image[ cnt  ];
    int         step = 0;

    imgs[ 0 ] = closedMouthImage;
    imgs[ 1 ] = openMouthImage;

            while ( engine.isRunning )
            {
                this.setCurrImg( imgs[ step ] );
                    draw(engine.getGraphics());
                step = ( step + 1 ) % cnt;
                    try
                    {
                                Thread.sleep(100);
                    }
                    catch (InterruptedException e) {}
            }
}