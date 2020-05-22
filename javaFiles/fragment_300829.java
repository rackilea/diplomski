String roundString;
            if (round < halfRoundMark) {
                roundString = ("team " + (home + 1)
                        + " plays against team " + (away + 1));
            } else {
                roundString = ("team " + (away + 1)
                        + " plays against team " + (home + 1));
            }
            rounds[round][match] = roundString;