vv.setVertexToolTipTransformer(new Transformer<String, String>() {
        public String transform(String v) {

        //  i=0;
            try {

                 String bb = "SELECT * FROM interr";
                Statement pest = connection.createStatement();
                ResultSet v1 = pest.executeQuery(bb);   
                while(v1.next())
                    if(v.toString().equals(v1.getString("Mole1")))
                 na[i] = v1.getString("Pubchem_ID");
                System.out.println(na[i]);
                v=na[i].toString();
                return "PUBMED:"+v.toString();
            }
        catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);

        }
            return null;

        }
    });