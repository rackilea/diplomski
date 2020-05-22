IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

IMarker[] markers = root.findMarkers(IMarker.PROBLEM, false, IResource.DEPTH_ZERO);

for (int i = 0; i < markers.length; i++) {
  String message = (String) markers[i].getAttribute(IMarker.MESSAGE);

  if (message != null && message.startsWith("this is a test")) {
    markers[i].delete();
  }
}

//IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
Map attribs = new HashMap();
for (int i = 0; i < 8; i++) {
  attribs.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
  attribs.put(IMarker.MESSAGE, "this is a test " + i);
  attribs.put("bogus field", "some text");
  MarkerUtilities.createMarker(root, attribs, IMarker.PROBLEM);
}