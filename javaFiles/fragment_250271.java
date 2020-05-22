try {
                PrintWriter r= (PrintWriter) i.next();

                String[] s={"f","ff"};
                for(String sElement : s)
                {
                    r.println(sElement);
                    r.flush();
                }

            } catch (Exception ex) {

            }