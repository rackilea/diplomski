String s = "0110100001100101011011000110110001101111";
    String str = "";

    for (int i = 0; i < s.length()/8; i++) {

        int a = Integer.parseInt(s.substring(8*i,(i+1)*8),2);
        str += (char)(a);
    }

    System.out.println(str);