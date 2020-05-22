import CryptoJS from 'crypto-js' ;
encryptFun() {
    var data = "123456";
    var key  = CryptoJS.enc.Latin1.parse('1234567812345678');
    var iv   = CryptoJS.enc.Latin1.parse('1234567812345678');  
    var encrypted = CryptoJS.AES.encrypt(
      data,
      key,
      {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding
    });
    console.log('encrypted: ' + encrypted) ;
    var decrypted = CryptoJS.AES.decrypt(encrypted,key,{iv:iv,padding:CryptoJS.pad.ZeroPadding});
    console.log('decrypted: '+decrypted.toString(CryptoJS.enc.Utf8));
  }