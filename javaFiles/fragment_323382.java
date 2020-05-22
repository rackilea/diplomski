if (f.getType().getName().equals(int.class.getName()))
            m.invoke(res, Integer.parseInt(f.getText()));
     else if (f.getType().getName().equals(double.class.getName()))
         m.invoke(res, Double.parseDouble(f.getText()));
     else if (f.getType().getName().equals(boolean.class.getName()))
         m.invoke(res, Boolean.parseBoolean(f.getText()));
    ....