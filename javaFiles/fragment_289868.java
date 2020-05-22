public final void acceptSearchMatch(final SearchMatch  match) throws CoreException  {
  final SearchMatch accepted= fRequestor.acceptSearchMatch(match);
  if (accepted != null) {
    fCollectedMatches.add(accepted);
    final IResource resource= accepted.getResource();
    if (!resource.equals(fLastResource)) {
      if (fBinary) {
        final IJavaElement element= JavaCore.create(resource);