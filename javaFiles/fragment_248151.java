Field[] fields = ABeanClass.getDeclaredFields();

Object[] values = new Object[fields.length];

int i = 0;

for (Field field : fields) {
    values[i] = field.get(beanInstance);
    i++;
}