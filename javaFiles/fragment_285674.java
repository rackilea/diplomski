String str = "NC43-EB2;49.21716;-122.667252;49.216757;-122.666235;";
   String[]s = str.split(";");
   String[]n = s[0].split("-");

   String name = n[0].substring(1);       
   String direction = n[1]; 

   String c1 = s[1] +";"+s[2];        
   String c2 = s[3] +";"+s[4];

   System.out.println(name + " " + direction);
   System.out.println(c1 + " " + c2);