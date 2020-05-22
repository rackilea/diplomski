public int toNumber(String n) {
    int number = 0;

    for (char chr : n.toUpperCase().toCharArray()) {
        switch(chr) {
            case 'I': number += 1;
                      break;
            case 'V': number += 5;
                      break;
            default: break;
        }
    }

    return number;
}