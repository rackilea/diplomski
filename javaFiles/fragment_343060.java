private void stopAllPlayers(){

if(mdx1 != null && mdx1.isPlaying())
        {mdx1.stop();mdx1.reset(); mdx1.release();}
if(mdx2 != null && mdx2.isPlaying())
        {mdx2.stop();mdx2.reset(); mdx2.release();}
if(mdx3 != null && mdx3.isPlaying())
        {mdx3.stop();mdx3.reset(); mdx3.release();}
if(mdx4 != null && mdx4.isPlaying())
        {mdx4.stop();mdx4.reset(); mdx4.release();}
if(mdx5 != null && mdx5.isPlaying())
        {mdx5.stop();mdx5.reset(); mdx5.release();}
if(mdx6 != null && mdx6.isPlaying())
        {mdx6.stop();mdx6.reset(); mdx6.release();}
}