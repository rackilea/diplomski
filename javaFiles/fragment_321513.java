strTime1 varchar2(50);
        strTime2 varchar2(50);
        v_date1 date ;
        v_date2 date;
        actualStartDate varchar2(50);
        actualEndDate varchar2(50);
        startmillisec varchar2(50);
        endmillisec varchar2(50);
        difrence_In_Hours number;
        difrence_In_minutes number;
        difrence_In_seconds number := 0;
        difrence_In_milliseconds number := 0;

        SELECT val_x INTO V_F_LEG FROM table_x WHERE PARAM_ss=i.PARAM_ss AND PARAM_ff= '1';

       SELECT PARAM_rr INTO V_L_LEG FROM table_x WHERE PARAM_ss=i.PARAM_ss AND PARAM_ff= '2' AND PARAM_gg IS NOT NULL;

            actualStartDate := substr(V_F_LEG,1,14);
            actualEndDate :=  substr(V_L_LEG,1,14);
            -- handling milliseconds seperately

            startmillisec := substr(V_F_LEG,15,3);
            endmillisec := substr(V_L_LEG,15,3);

            v_date1  := to_date(actualStartDate,'YYYYMMDDHHmiSS');
            v_date2 := to_date(actualEndDate,'YYYYMMDDHHmiSS');
               difrence_In_milliseconds := endmillisec - startmillisec;
               difrence_In_Hours   := (v_date2 - v_date1) * 24;
               difrence_In_minutes := difrence_In_Hours * 60;
               if abs(difrence_In_milliseconds) > 500 then
               difrence_In_seconds := round((difrence_In_minutes * 60)+1);
              else
              difrence_In_seconds := round(difrence_In_minutes * 60);
              end if;

            V_DURATION := difrence_In_seconds;