for (int i = 0; i < value.length(); i++) {
        if (value.charAt(i) < '0')   {
              return false;
        }
        if (value.charAt(i) >= base + '0') {
                return false; 
        }
}
return true;