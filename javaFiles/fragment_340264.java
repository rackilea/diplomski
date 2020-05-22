switch(i % 3) {
    case 0: 
        v1 = input.nextInt(); 
        break;
    case 1: 
        v2 = input.nextInt();
        break;
    case 2: 
        s = input.next();
        items[i] = new Data(v1, v2, s);
        break;
 }
 ++i;