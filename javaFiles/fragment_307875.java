while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
            {
                num.append(tokens[i++]);
            }
            if (i != tokens.length)
                i--;