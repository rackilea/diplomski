for (int i = 0; i < arr.length; i++) {
            s += "'".concat(arr[i]).concat("'") + ',';
        }

        s = s.concat(")");

        System.out.print(s.replace(",)", ")"));