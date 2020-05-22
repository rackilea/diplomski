converter.setSupportedMediaTypes(Arrays.asList(
            new MediaType("application", "doesntmatter") {
                @Override
                public boolean isCompatibleWith(final MediaType other) {
                    if (other == null) {
                        return false;
                    }
                    else if (other.getSubtype().startsWith("vnd.") && other.getSubtype().endsWith("+json")) {
                        return true;
                    }
                    return super.isCompatibleWith(other);
                }
            }
));