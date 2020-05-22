134     private  static boolean isBase64(byte octect) {
135         if (octect == PAD) {
136             return true;
137         } else if (base64Alphabet[octect] == -1) { // <---
138             return false;
139         } else {
140             return true;
141         }
142     }