const crypto = require('crypto');

const ed = 'OGtANbvTLY6Cme2VNAxsiIhBLLwl29oVX7zC5DGmmq4hU/VqNKaGQuSp1Q8liQ94cW/B96OJoJJ2r67jRlQFI4qHCTWFU2qQ8QaNj6WehdVLsf5mDK2aMQ=='
const key = 'HuzPEZgzqKOo8VwlnYhNUaPWTWSVDRQ2bMtY6aJAp8I'
const iv = 'kg5ILA0826hrew5w'
const tag = 'jc/vXd1ha/cElMBzFaIp9g==' // last 16 bytes extracted in java

function decrypt(encrypted, ik, iiv, it) {
  let bData = Buffer.from(encrypted, 'base64');
  let tag1 = Buffer.from(tag, 'base64');
  let iv1 = Buffer.from(iiv, 'base64');
  let key1 = new Buffer(ik, 'base64');
  let decipher = crypto.createDecipheriv('aes-256-gcm', key1, iv1)
  decipher.setAuthTag(tag1);
  let dec = decipher.update(bData, 'utf8')
  dec += decipher.final('utf8');
  return dec;
}
console.log(decrypt(ed,key,iv,tag))