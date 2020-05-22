while (x <= 4) // start of thought problem
        {
            if (!(z.contains("a") || z.contains("e") || z.contains("i")
                    || z.contains("o") || z.contains("u"))) {
                z = end.substring(0, x);                
            }
            x = x + 1;
        }