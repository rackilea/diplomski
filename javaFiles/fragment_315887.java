List<MSSVectorAlg> vectors = new ArrayList<MSSVectorAlg>();

int xTotal = 0, yTotal = 0, zTotal = 0;
for (MSSVectorAlg vector : vectors)
{
   xTotal  += vector.getX();
   yTotal  += vector.getY();
   zTotal  += vector.getZ();
}