PGN_PATTERN = "(?:^\\[\\w+\\s+\"[^\"]*\"\\]\n+)+\n*(.*?(1-0|0-1))"; 
                ^                 ^         ^    |         ^
                |                 |         |    |         |
                |                 |         |    |         -- how do you match draws?
                |                 |         |    ---- blank lines between headers and body
                |                 |         --- you need to match the lines too
                |                 ---- so it won't match all the tags at once and will be faster
                ------- we're skipping them, so (?:…)