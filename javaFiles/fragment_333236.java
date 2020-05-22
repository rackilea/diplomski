int imagesRid = {R.id.imageA, R.id.imageB, R.id.imageC}
for(int i=0;i<anyNo;i++)
{
     view.setBrackground(context.getResources().getDrawable(imagesRid[i%imagesRid.lenght]))    

}