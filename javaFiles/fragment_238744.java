void getNum()
  {
       for (int i =0; i< 3; i++)
       {
          phone[i] = (p[i] + code[0]) % 10;
       }
       for (int i =3; i< 6; i++)
       {
          phone[i] = (p[i] + code[1]) % 10;
       }
       for (int i =6; i< p.length; i++)
       {
          phone[i] = (p[i] + code[2]) % 10;
       }
  }