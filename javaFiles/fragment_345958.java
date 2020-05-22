Number[] numArr = null;
Integer[] intArr = null;

numArr = intArr;
intArr = numArr;              //Compile error
intArr = (Integer[]) numArr;