int mid = nArray.length / 2;

for(int i = 0; i < nArray.length; i++){
    if (i > mid){ // line is past mid point, fill it with 'u'
        Arrays.fill(nArray[i], 'u');
    } else if (i == mid){ // line is mid point, fill it with `===`
        Arrays.fill(nArray[i], '=');
    } else { // line is before mid point, fill it with `o`
        Arrays.fill(nArray[i], 'o');
    }
}

for (int j = 0; j < nArray.length; j++){
    System.out.println(Arrays.toString(nArray[j]));
}