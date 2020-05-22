while (st.hasMoreTokens()) 
            {
                String token = st.nextToken();
                float cv0 = contVal(a1,token);
                cv1 = cv0*cv1;
                float cv3 = contVal2(a1,token);
                cv4=cv3*cv4;
            }