ArrayList<Integer> s = getSlice(rz, rx);
    ArrayList<Integer> s2 = getSlice(rz, ry);

    boolean yMax = Math.max(s2.size(), s.size()) == s2.size();

    int decX = s.size() - 1;
    int decY = s2.size() - 1;

    boolean done = false;

    while (!done)
    {

        int x = 0;
        int z = 0;
        int z2 = 0;
        int y = 0;

        y = s2.get(decY--);
        z2 = s2.get(decY--);

        x = s.get(decX--);
        z = s.get(decX--);

        if (z != z2)
        {
            if (yMax)
            {
                decX += 2;
                x = s.get(decX);

                s2.remove(decY + 2);
                s2.remove(decY + 1);    
            }
            else
            {
                decY += 2;
                y = s2.get(decY);

                s.remove(decX + 2);
                s.remove(decX + 1); 
            }

            z = z < z2 ? z : z2;
        }
        else
        {
            s.remove(decX + 2);
            s.remove(decX + 1);             

            s2.remove(decY + 2);
            s2.remove(decY + 1);    
        }

        if (y != 0 && x != 0)
            generateEllipse(z, cx, cy, cz, x, y);

        done = yMax ? s2.isEmpty() : s.isEmpty();
    }