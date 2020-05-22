int up = 1;
    DO_WHILE_LOOP : do{
        switch(up){
        case 1:
            up = 0;
            if (yourCondition) break DO_WHILE_LOOP; break;
        case 0: 
            up = 1;
            if (yourCondition) break DO_WHILE_LOOP; break;
        }
    } while (true);