if(exes.get(i) > width || exes.get(i) <= 0)
{
  print("side wall hit");
  xSpeeds.set(i, i*= slope);
}
if(whys.get(i) > height || whys.get(i) <= 0)
{
  print("roof hit");
  ySpeeds.set(i, i*= slope);
}