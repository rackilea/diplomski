int randNum2 = new Double( (Math.random()+1) * 100000000).intValue();
String aString`enter code here` = Integer.toString(randNum2);
int[] cpf = new int[aString.length()+3];
for (int i = 0; i < aString.length(); i++) {
    cpf[i] = Character.digit(aString.charAt(i), 10);
}
cpf[9]=10*cpf[0]+9*cpf[1]+8*cpf[2]+7*cpf[3]+6*cpf[4]+5*cpf[5]+4*cpf[6]+3*cpf[7]+2*cpf[8];
cpf[9]=11-(cpf[9] %11);
if(cpf[9]>9)
{
    cpf[9]=0;
}
cpf[10]=11*cpf[0]+10*cpf[1]+9*cpf[2]+8*cpf[3]+7*cpf[4]+6*cpf[5]+5*cpf[6]+4*cpf[7]+3*cpf[8]+2*cpf[9];
cpf[10]=11-(cpf[10] %11);
if(cpf[10]>9)
{
    cpf[10]=0;
}