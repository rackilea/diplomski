CryptoJS.pad.NoPadding = {pad: function(){}, unpad: function(){}};

var text = "My Secret text\0\0";
var key  = CryptoJS.enc.Hex.parse("253D3FB468A0E24677C28A624BE0F939");
var iv   = CryptoJS.enc.Hex.parse("00000000000000000000000000000000");

var encrypted = CryptoJS.AES.encrypt(text, key, {iv: iv, padding: CryptoJS.pad.NoPadding});

console.log(encrypted.toString());