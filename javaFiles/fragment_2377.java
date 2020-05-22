boolean isTriangle = true;
if (!(num1+num2>num3)||!(num1+num3>num2)||!(num2+num3>num1)){
   isTriangle = false;
}

if (isTriangle == true){
   System.out.println("It is a valid triangle");
} else {
   System.out.println("It is not a valid triangle");
}