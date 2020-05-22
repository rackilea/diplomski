distance=0;
for(int i=0; i<imgMat.rows();i++)
{ 
    for(int j=0; j<imgMat.cols();j++)
    {
        distance+=(mDescriptors1.get(i, j)[0]-mDescriptors2.get(i, j)[0])*(mDescriptors1.get(i, j)[0]-mDescriptors2.get(i, j)[0]);
    }
}