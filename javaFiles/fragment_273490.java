String[] alpha= {"A","B","C" ,"D" ,"E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
int alp = alpha.length;
StringBuffer alphabet = new StringBuffer();
for (int i=0;i<alpha.length;i++){
  alphabet.append(alpha[i]);
}
alphabets.setText(alphabet.toString());