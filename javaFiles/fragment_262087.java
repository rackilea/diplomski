c.eval("for(i in 1:length(system))"
                    + "{"
                    +     "j=sum(system[1:i]);"
                    +     "systemw[i]=sum(indexw[1:j])-k;"
                    +     "k=sum(systemw[1:i])"
                    + "}");