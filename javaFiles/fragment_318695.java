@Override
public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> config, Annotated a) {
            JsonCreator ann = _findAnnotation(a, JsonCreator.class);
            // THIS IS THE FIXING BIT
            // Note: I only enable this for your specific class, all other cases are handled in default manner 
            Class<?> rawType = a.getRawType();
            if(ann == null && rawType.isAssignableFrom(DateSettings.class)) { 
                return JsonCreator.Mode.DEFAULT;
            }
            if (ann != null) {
                JsonCreator.Mode mode = ann.mode();
                // but keep in mind that there may be explicit default for this module
                if ((creatorBinding != null)
                        && (mode == JsonCreator.Mode.DEFAULT)) {
                    mode = creatorBinding;
                }
                return mode;
            }
            return null;
        }