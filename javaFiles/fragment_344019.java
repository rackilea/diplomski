int i, a, b, c, d, yil = 1999, rt = 0;
        //loop searching for 1976
        for( i = 1900; i < 2000; i++){
            //separate "i" to the digits
            a = i / 1000;
            b = i % 1000 / 100;
            c = i % 1000 % 100 / 10;
            d = i % 1000 % 100 % 10;
            rt = a + b + c + d;
            if (rt==yil-i) break;
        }
        System.out.println("Yıl = " + i );  }