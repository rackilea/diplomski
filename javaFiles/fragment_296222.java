crypto = require('crypto');

function encrypt(data,key) {
    var cipher = crypto.createCipheriv('aes-128-ecb', key,''); //create aes-128 cipher 
    var encrypted = cipher.update(data,'utf8', 'hex'); //output as hex
    return encrypted;
}

function padRightTo32(str) { // ensure block size of 32

    len=str.length;
    for(i=len; i%32>0; i++) {
        str=str +" ";
    }
    return str;
}

// call to encryption function
var hexKey = new Buffer('3b6ce332ca3b6519eac769710f41ca5c', 'hex'); // 16 Byte-key
encStr=encrypt(padRightTo32("Hello"),hexKey);
console.log(encStr);