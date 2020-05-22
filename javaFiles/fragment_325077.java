function CalculateCredentialsSecret(type, user, pwd) {

var days = days_between(new Date(), new Date(2000, 1, 1)) + 30;
var str = type.toUpperCase() + user.toUpperCase() + pwd.toUpperCase() + days;

var padding_data = String.fromCharCode(239, 187, 191);

var md5 = rstr_md5(padding_data+str);
var b64 = base64Encode(md5);

return encodeURIComponent(b64);
}