public class PredefinedValidator
{
    public boolean validate(Predefined predefined, Map<UUID, String> mappings)
    {
        if (predefined == null)
            return false;

        for (Field field :predefined.getClass().getDeclaredFields())
        {
            if (field.getType().equals(UUID.class))
            {
                try
                {
                    Annotation[] annotations = field.getDeclaredAnnotations();
                    UUID uuid = (UUID)field.get(predefined);
                    if (!this.validateField(uuid, annotations, mappings))
                        return false;
                }
                catch (IllegalArgumentException | IllegalAccessException ex)
                {
                    Logger.getLogger(PredefinedValidator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }

    private boolean validateField(UUID field, Annotation[] annotations, Map<UUID, String> mapping)
    {
        boolean containsSize = false;
        boolean containsNotNull = false;
        int minSize = -1;
        int maxSize = -1;

        // fetch which annotations are available for the provided field
        for (Annotation annotation : annotations)
        {
            if (annotation instanceof Size)
            {
                containsSize = true;
                Size size = (Size)annotation;
                minSize = size.min();
                maxSize = size.max();
            }
            else if (annotation instanceof NotNull)
                containsNotNull = true;
        }

        // check if the provided value is null and an annotatition for @NotNull
        // is set
        if (field == null && containsNotNull)
            return false;

        if (containsSize)
        {
            // get the value of the mapped UUID which we are going to validate
            String value = mapping.get(field);
            if (value == null && containsNotNull)
                return false;
            else if (value == null)
                return true;

            // check if the length of the value matches
            if (value.length() <= minSize || value.length() >= maxSize)
                return false;
        }

        // passed all tests
        return true;
    }
}