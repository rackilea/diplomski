StringBuilder sb = new StringBuilder();
Random random = new Randdom();
for(int i=0; i<7; i++) {
    sb.append(pwdCharArray[random.nextInt(0, pwdCharArray.length -1)]);
}
return sb.toString();