this.hexStringToByteArray = function(s) {

    var len = s.length;
    var data = [];
    for(var i=0; i<(len/2); data[i++]=0) {} 

    for (var i = 0; i < len; i += 2) {

        var value = (parseInt(s.charAt(i), 16) << 4)
                             + parseInt(s.charAt(i+1), 16);

        // "transforms" your integer to the value a Java "byte" would have:
        if(value > 127) {
            value -= 256;
        }

        data[i / 2] = value;

    }

    return data;

};