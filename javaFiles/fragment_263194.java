public void setRadius(int radius)
{
  this.radius = radius;
  diameter = radius + radius; // <-- 2*radius (not radius*radius)
  area = Math.PI * (radius * radius);
}