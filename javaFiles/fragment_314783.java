boolean must_translate = true;
                for(int i = 0; i < y; i++)
                    {
                        if (z[i].equals("[")) { must_translate = false; }
                        else if (z[i].equals("]")) { must_translate = true; }
                        else {
                           if (must_translate) {
                               switch (z[i])
                               // (....)
                           } else {
                               System.out.print(z[i]);
                           }
                        }