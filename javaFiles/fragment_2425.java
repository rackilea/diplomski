public static void main(String[] args) {

        try {

            Class columnNames = User.class;

            List<String> columnGroups = new ArrayList<String>();
            columnGroups.add("UserName");
            columnGroups.add("EmailId");

            BeanInfo info = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] props = info.getPropertyDescriptors(); //Gets all the properties for the class.

            List<String> modelClassFields = new ArrayList<String>();

            for(String columnField : columnNames){

                for(Method method : clazz.getDeclaredMethods()){

                javax.persistence.Column col = method.getAnnotation(javax.persistence.Column.class); //check for the method annotated with @Column
                if(col != null) {
                    String colName = col.name();
                    if(colName!=null && colName.equals(columnField)) { checking the column attrubute name and the value from given list is equal.
                        for (PropertyDescriptor pd : props) 
                        {  
                            if(method.equals(pd.getWriteMethod()) || method.equals(pd.getReadMethod()))
                            {
                                modelClassFields.add(pd.getDisplayName());
                                System.out.println(pd.getDisplayName());
                            }
                        }
                    }

                }
            }

        }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }