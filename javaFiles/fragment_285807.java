import 'dart:io';
import 'dart:convert';


// ...

new File('/data/user/0/com.example.foo/app_flutter/config.json')
    .readAsString()
    .then((fileContents) => JSON.decode(fileContents))
    .then((jsonData) {
        // do whatever you want with the data
    });