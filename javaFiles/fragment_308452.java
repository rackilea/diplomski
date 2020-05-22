public class Vector3
{
   public float x,y,z;
   public Vector3(float x,float y, float z)
   {
   this.x = x;
   this.y = y;
   this.z = z;
   }
   public void add(Vector3 v)
   {
    this.x += v.x;
    this.y += v.y;
    this.z += v.z;
   }
 public void set(float x, float y ,float z)
   {
    this.x = x;
    this.y = y;
    this.z = z;
   }

}