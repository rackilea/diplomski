/* MD5 in byte[] format */
function byteArray_md5(s) {
        var output = [];
        var input = rstr_md5(str2rstr_utf8(s)); //here it uses md5.js
        for(var i = 0; i < input.length; i++)
                output[i] = input.charCodeAt(i);
        return output;
}
/* MD5 with custom mapping.
 * It's a normal MD5 with a final char mapping of the hash.
 */
function md5WithCustomMapping(source) {
    var codes = "$0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz£";
    var digest = byteArray_md5(source);

    var result = [];
    for (var i = 0; i < digest.length; ++i)
        result.push(
                codes.charAt(
                        ~~( ( digest[i] + 128 * (digest[i]<128 ? 1 : -1) )/4 )
                        )
                    );
    return result.join('');
}