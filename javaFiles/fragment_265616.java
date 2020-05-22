BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new ConvertUtilsBean() {
            @Override
            public Object convert(String value, Class clazz) {
                  if (clazz.isEnum()){
                       return Enum.valueOf(clazz, value);
                  }else{
                       return super.convert(value, clazz);
                  }
           }
        });