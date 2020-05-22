function getRangeArray(pulselen){

    var myOptions = [];
    var array = [0.5,1,2,5,10,20,40];
    console.log("Length got is " + pulselen);
    for(i=0;i<array.length;i++){
        myOptions.push({label: array[i].toString(), value: "" + array[i]*1000 });
    }
    return myOptions;
}