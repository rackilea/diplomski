result = Git.cloneRepository()
        .setURI( 'https://github.com/github/testrepo.git' )
        .setDirectory( localPath )
        .call();

// this is currently necessary to free all file locks
result.getRepository().close();

result.close();