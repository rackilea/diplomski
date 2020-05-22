Git git = Git.cloneRepository...
try {
    // whatever
} finally {
    if (git != null) git.close();
}