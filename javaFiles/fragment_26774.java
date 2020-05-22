public class DateTimeFormatAwareElResolver extends ELResolver implements ServletContextListener {
      private final ThreadLocal<Boolean> isGetValueInProgress = new ThreadLocal<>();

      @Override
      public void contextInitialized(ServletContextEvent event) {
        JspFactory.getDefaultFactory().getJspApplicationContext(event.getServletContext()).addELResolver(this);
      }

      @Override
      public void contextDestroyed(ServletContextEvent sce) {}

      @Override
      public Object getValue(ELContext context, Object base, Object property) {
        try {
          if (Boolean.TRUE.equals(isGetValueInProgress.get())) {
            return null;
          }

          isGetValueInProgress.set(Boolean.TRUE);
          Object value = context.getELResolver().getValue(context, base, property);
          if (value != null && isFormattableDate(value)) {
            String pattern = getDateTimeFormatPatternOrNull(base, property.toString());
            if (pattern != null) {
              return format(value, DateTimeFormatter.ofPattern(pattern));
            }
          }
          return value;
        }
        finally {
          isGetValueInProgress.remove();
        }
      }

      private boolean isFormattableDate(Object value) {
        return value instanceof LocalDate || value instanceof LocalDateTime;
      }

      private String format(Object localDateOrLocalDateTime, DateTimeFormatter formatter) {
        if (localDateOrLocalDateTime instanceof LocalDate) {
          return ((LocalDate)localDateOrLocalDateTime).format(formatter);
        }
        return ((LocalDateTime)localDateOrLocalDateTime).format(formatter);
      }

      private String getDateTimeFormatPatternOrNull(Object base, String property) {
        DateTimeFormat dateTimeFormat = getDateTimeFormatAnnotation(base, property);
        if (dateTimeFormat != null) {
          return dateTimeFormat.pattern();
        }

        return null;
      }

      private DateTimeFormat getDateTimeFormatAnnotation(Object base, String property) {
        DateTimeFormat dtf = getDateTimeFormatFieldAnnotation(base, property);
        return dtf != null ? dtf : getDateTimeFormatMethodAnnotation(base, property);
      }

      private DateTimeFormat getDateTimeFormatFieldAnnotation(Object base, String property) {
        try {
          if (base != null && property != null) {
            Field field = base.getClass().getDeclaredField(property);
            return field.getAnnotation(DateTimeFormat.class);
          }
        }
        catch (NoSuchFieldException | SecurityException ignore) {
        }
        return null;
      }

      private DateTimeFormat getDateTimeFormatMethodAnnotation(Object base, String property) {
        try {
          if (base != null && property != null) {
            Method method = base.getClass().getMethod("get" + StringUtils.capitalize(property));
            return method.getAnnotation(DateTimeFormat.class);
          }
        }
        catch (NoSuchMethodException ignore) {
        }
        return null;
      }

      @Override
      public Class<?> getType(ELContext context, Object base, Object property) {
        return null;
      }

      @Override
      public void setValue(ELContext context, Object base, Object property, Object value) {
      }

      @Override
      public boolean isReadOnly(ELContext context, Object base, Object property) {
        return true;
      }

      @Override
      public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
        return null;
      }

      @Override
      public Class<?> getCommonPropertyType(ELContext context, Object base) {
        return null;
      }
    }