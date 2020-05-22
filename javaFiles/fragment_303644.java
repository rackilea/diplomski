zone        =  "UT"  / "GMT"                ; Universal Time
                                             ; North American : UT
             /  "EST" / "EDT"                ;  Eastern:  - 5/ - 4
             /  "CST" / "CDT"                ;  Central:  - 6/ - 5
             /  "MST" / "MDT"                ;  Mountain: - 7/ - 6
             /  "PST" / "PDT"                ;  Pacific:  - 8/ - 7
             /  1ALPHA                       ; Military: Z = UT;
                                             ;  A:-1; (J not used)
                                             ;  M:-12; N:+1; Y:+12
             / ( ("+" / "-") 4DIGIT )        ; Local differential
                                             ;  hours+min. (HHMM)