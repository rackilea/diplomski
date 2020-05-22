public class TransientRespectingBeanProvider extends BeanProvider {
        @Override
        protected boolean canStreamProperty(PropertyDescriptor descriptor) {
            final boolean canStream = super.canStreamProperty(descriptor);
            if (!canStream) {
                return false;
            }

            final boolean readMethodIsTransient = descriptor.getReadMethod() == null
                    || descriptor.getReadMethod().getAnnotation(Transient.class) != null;
            final boolean writeMethodIsTransient = descriptor.getWriteMethod() == null
                    || descriptor.getWriteMethod().getAnnotation(Transient.class) != null;
            final boolean isTransient = readMethodIsTransient
                    || writeMethodIsTransient;

            return !isTransient;
        }
    }