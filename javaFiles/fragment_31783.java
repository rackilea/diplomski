myClass c;
if (i < classesOn.lenght && classesOn[i])  { 
    c = classes[i]
        .getConstructor(float.class, float.class)
        .newInstance(mouseX, mouseY); 
} else {
    c = new myClass1(mouseX, mouseY);
}