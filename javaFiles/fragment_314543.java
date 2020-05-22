do {

            int mid = line / 2; // find the middle.
            int gap = 0; // 'gap' is for the gap between the stars .
            for (int i = 0; i < line; i++) // loop for the creation of letter K.
            {
                if (i == 0)
                    gap = mid;
                if (i < mid) // if it is before the middle of letter K, start
                                // printing stars and gaps but start with
                                // gap=middle and the decrease the number of
                                // gaps as you change lines.
                {

                    output += "*";
                    for (int j = gap; j > 0; j--) // placement of gaps between
                                                    // the stars.
                    {
                        output += " ";
                    }
                    output += "*\n";
                    gap--;
                } else if (i == mid && i != 0) // if it is in the middle of
                                                // letter K, it will print only
                                                // one star.
                {
                    output += "*\n";
                    gap = 1;
                } else // if it is past the middle section of letter K, it will
                        // continue printing gaps but now the gaps start from 0
                        // and keep increasing at each line.
                {
                    output += "*";
                    for (int j = 0; j < gap; j++) // placement of gaps between
                                                    // the stars.
                    {
                        output += " ";
                    }
                    output += "*\n";
                    gap++;
                }

            }
            JOptionPane.showMessageDialog(null, output);

            line = Integer.parseInt(JOptionPane.showInputDialog(
                    "Give me a number ", 4)); // input from input panel.
            output = "";
        } while (line >= 4 && line <= 30);