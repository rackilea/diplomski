public class AnnotationStrategy extends HeaderColumnNameTranslateMappingStrategy
    {
        public AnnotationStrategy(Class<?> clazz)
        {
            Map<String,String> map=new HashMap<>();
            for(Field field:clazz.getDeclaredFields())
            {
                CsvBindByName annotation = field.getAnnotation(CsvBindByName.class);
                if(annotation!=null)
                {
                    map.put(annotation.column(),annotation.column());
                }
            }
            setType(clazz);
            setColumnMapping(map);
        }

        @Override
        public String[] generateHeader(Object bean) throws CsvRequiredFieldEmptyException
        {
            String[] result=super.generateHeader(bean);
            for(int i=0;i<result.length;i++)
            {
                result[i]=getColumnName(i);
            }
            return result;
        }
    }