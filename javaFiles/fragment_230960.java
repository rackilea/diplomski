const crypto = require('crypto');
msg = Buffer.from('SfosHg+cTrQXYUdF0FuqCJMHgfcP13ckp2L0B9QqOcl8UtWnnl8fLi5lxgR2SKOj','base64');
aeskey = Buffer.from('JUtwW8+qU6Mv/FcgbMbkOdOKy72pun4B490KQrRB4QQ=','base64');
dec = crypto.createDecipheriv('aes-256-cbc',aeskey,Buffer.alloc(16)/*this should be the IV*/);
console.log(dec.update(msg,'','latin1')+dec.final('latin1'));
// I used latin1 instead of utf8 because the garbaged first block 
// isn't valid UTF-8, and the rest is ASCII which works as either.
->
Y;øï«*M2WÚâeage to be encrypted
// some garbaged chars are control chars and Stack (or browser?) 
// may not display them but there really are 16 in total