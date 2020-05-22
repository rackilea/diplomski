IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(ResourcesPlugin.PI_RESOURCES,
            ResourcesPlugin.PT_MARKERS);

IExtension [] extensions = point.getExtensions();

for (IExtension extension : extensions) {
    String id = ext.getUniqueIdentifier();

    if ("org.eclipse.jdt.core.problem".equals(id)) {
       String label = ext.getLabel();

       // TODO save the label
    }
}