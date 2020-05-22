SVNClientManager ourClientManager = SVNClientManager.newInstance(null, 
            repository.getAuthenticationManager());
SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
updateClient.setIgnoreExternals(false);
updateClient.doCheckout(url, destPath, revision, revision,
            isRecursive);