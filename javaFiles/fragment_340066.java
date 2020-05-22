String serverAddress = server_address.getText.toString();
    String serverPort = server_port.getText.toString();
    String password = server_password.getText.toString();
    String encryptMethod = encrypt_method.getText.toString();

b64_code.setText(serverAddress.concat(":").concat(serverPort).concat(":").concat(password).concat(":").concat(encryptMethod));