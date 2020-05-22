if (f.getType() == Integer.TYPE)
            m.invoke(res, Integer.parseInt(f.getText()));
     else if (f.getType() == Double.TYPE)
         m.invoke(res, Double.parseDouble(f.getText()));
     else if (f.getType() == Boolean.TYPE)
         m.invoke(res, Boolean.parseBoolean(f.getText()));
     ...