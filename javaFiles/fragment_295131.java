Object[] objects = new Object[10];
for (int i = 0; i < objects.lengthl i++){
    objects[i] = new Object();
}  

StringBuilder sb = new StringBuilder();
for (Object o : objects){
    sb.append(o + "\n");
} 

JOptionPane.showMessageDialog(null, sb.toString());