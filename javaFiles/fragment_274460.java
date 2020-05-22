@Override
public IPDOMDescriptor[] getDescriptors(ICConfigurationDescription config) {
    final IPath fileBase = Path.fromOSString("/home/sadik/eclipse-2019-06/eclipse/");
    final IPath projectBase = config.getProjectDescription().getProject().getFullPath();
    return new IPDOMDescriptor[] { new IPDOMDescriptor() {
        public IIndexLocationConverter getIndexLocationConverter() {
            URI baseURI;
            try {
                baseURI = new URI(projectBase.toString()+"/");
                return new URIRelativeLocationConverter(baseURI);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            baseURI = URIUtil.toURI(projectBase);
            return new URIRelativeLocationConverter(URIUtil.toURI(projectBase));
        }
        public IPath getLocation() {
            IPath path = fileBase.append("pdomExample.pdom");
            return path;
        }
    }};
}