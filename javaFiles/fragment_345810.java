while (true) 
{
        line = in.readLine();
        String tmp[] = line.split(" ");
        a = Integer.parseInt(tmp[0]);
        b = Integer.parseInt(tmp[1]);
        c = Integer.parseInt(tmp[2]);
        if (a == 0 || b == 0 || c == 0) {
            break;
        }
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        line = in.readLine();
        list.clear();
        tmp = line.split(" ");
        for (int i = 0; i < tmp.length; i++) {
            list.add(new Integer(Integer.valueOf(tmp[i])));
        }
        System.out.println("List = 4 3 2" + list);   
    }