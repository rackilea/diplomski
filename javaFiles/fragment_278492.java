int i;

for(i=0;i<button.length;i++){
     if(b[i].isEnabled()){
     break;
     }
}

if(i==button.length){
JOptionPane.showMessageDialog(null,"This was a Draw");
}