^                   # assert start of line
 (?!                # negtive lookahead group starts
    .*              # match any characters except new line
    (?:             # non-capturing group starts
        (\d).*\1|   # RULE#1: Same digits not allowed (e.g. 515, 330); OR 
        012|123|234|345|456|567|678|789|987|876|765|654|543|432|321|210
                    # RULE#2: Sequential digits not allowed (e.g. 567, 765)
    )               # non-capturing group ends
 )                  # negtive lookahead group ends
 (                  # capturing group starts
    \d{3,}          # match three or more digits (This is not RULE#3 )
 )                  # capturing group ends      
$                   # assert end of line