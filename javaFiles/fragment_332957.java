public static IMarker[] calculateCompilationErrorMarkers(IProject project)
{
    ArrayList <IMarker> result = new ArrayList <IMarker>();
    IMarker[] markers = null;
    markers = project.findMarkers(IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
    for (IMarker marker: markers)
    {
        Integer severityType = (Integer) marker.getAttribute(IMarker.SEVERITY);
        if (severityType.intValue() == IMarker.SEVERITY_ERROR)
                result.add(marker);
    }
    return result.toArray(new IMarker[result.size()]);
}