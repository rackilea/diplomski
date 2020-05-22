int atposition = 0, dotposition = 0, flag = 0;

for(int i = 0; i < get.length(); i++) {

    if(get.charAt(i) == a) {
                count++;
                atposition = i;

                if(count >= 2) {
                    flag = 1;
                    break;
                }
    }

   if (get.charAt(i) == '.') {
                dotposition = i;
    }
 }

 if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= get.length() || flag == 1) {
    message = "Not a valid e-mail address";
 } else {
    message = "valid email-id";
 }
 return message;