Original_Image(size) =  Result_Image (size) 

for( int i=1; i<Result_Image.rows-1;i++)  // ignore first and last rows to avoid going out of range
{
  for( int i=1;i<Result_Image.cols-1;i++)
{
     Result_Image(i,j)= -20*Result_Image(i,j)+6*(Result_Image(i-1,j)+Result_Image(i+1,j)+Result_Image(i,j-1)+Result_Image(i,j+1))-1*(Result_Image(i-1,j-1)+Result_Image(i+1,j+1)+Result_Image(i+1,j-1)+Result_Image(i-1,j+1));
}

}