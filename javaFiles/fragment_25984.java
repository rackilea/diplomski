cipher = function (mode, data) {
    var encipher, encoded;
    encipher = crypto[mode]("aes-256-cbc", key, iv);
    cipher1 = encipher.update(data);
    cipher2 = encipher.final();
    return  Buffer.concat([cipher1, cipher2]);
};