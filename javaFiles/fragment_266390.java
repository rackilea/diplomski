Wuerfelpaar wp = new Wuerfelpaar();
int[] wuerfel = wp.getWuerfel();
if(wp.istPaar()) {
   assertEqual(wuerfel[0], wuerfel[1]);
}
else {
   assertNotEqual(wuerfel[0], wuerfel[1]);
}